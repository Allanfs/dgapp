package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CadastrarPedidoTest {

	@MockBean
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PedidoServiceImpl service;
	
	private Pedido pedido;

	@BeforeEach
	void setUp() throws Exception {
		this.pedido = new Pedido();
		mockarMetodo(this.pedido);

	}
	
	@Test
	void cadastrarPedidoVazioEObterClienteNaoInformadoException() {
		assertThat(this.pedido.getEstado(), is(Estado.ABERTO));	
		assertThrows(ClienteNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	@DisplayName("Cadastrar pedido sem informar endereço, informando cliente sem endereço, e obter EnderecoNaoInformadoException")
	void cadastrarPedidoApenasComCliente() {
		
		Cliente cliente = new Cliente();
		
		pedido.setCliente(cliente);
		
		assertThrows(EnderecoNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	@DisplayName("Cadastrar pedido sem informar cliente, e obter ClienteNaoInformadoException")
	void cadastrarPedidoApenasComEndereco() {
		
		Endereco endereco = new Endereco();
		
		pedido.setEndereco(endereco);
		
		assertThrows(ClienteNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	@DisplayName("Cadastrar pedido sem informar itens, informando cliente com apenas um endereço, e obter PedidoSemItensException")
	void cadastrarPedidoSemItensComClienteComUmEndereco() {

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		HashSet<Endereco> enderecos = new HashSet<Endereco>();
		enderecos.add(endereco);
		endereco.setCliente(cliente);
		cliente.setEndereco(enderecos);
		

		pedido.setCliente(cliente);

		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido));

	}
	
	@Test
	@DisplayName("Cadastrar pedido sem informar itens, informando cliente com mais de um endereço, e obter EnderecoNaoInformadoException")
	void cadastrarPedidoSemItensComClienteComMaisDeUmEndereco() {

		Cliente cliente = new Cliente();
		HashSet<Endereco> enderecos = new HashSet<Endereco>();
		enderecos.add(Endereco.builder().id(UUID.randomUUID()).cliente(cliente).build());
		enderecos.add(Endereco.builder().id(UUID.randomUUID()).cliente(cliente).build());
		cliente.setEndereco(enderecos);

		pedido.setCliente(cliente);
		
		assertThrows(EnderecoNaoInformadoException.class, () -> service.cadastrar(pedido));
		
	}
	
	@Test
	void cadastrarPedidoComUmEnderecoQueNaoReferenciaCliente() {
		
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	@DisplayName("Cadastrar pedido informando cliente com um endereço, e um item com quantidade menor que zero, e obter PedidoSemItensException")
	void cadastrarPedidoComUnicoItemNegativo() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(new BigDecimal(15)).build();
		fail("Pedido não usa mais Map<Produto, Integer>. Agora usa List<ItemPedido>");
		// Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		// itens.put(produto, -1);
		// pedido.setItens(itens);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido) ); 

	}
	
	@Test
	@DisplayName("Cadastrar pedido informando cliente com um endereço, e três itens diferentes, e obter pedido cadastrado, com status aberto, três itens cadastrados")
	void cadastrarPedidoComItensComQuantidadePositiva() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(new BigDecimal(10)).build();
		Produto produto1 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(new BigDecimal(15)).build();
		Produto produto2 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(new BigDecimal(20)).build();
		
		fail("Pedido não usa mais Map<Produto, Integer>. Agora usa List<ItemPedido>");
		// Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		// itens.put(produto, 1);
		// itens.put(produto1, 3);
		// itens.put(produto2, 4);
		// pedido.setItens(itens);
		
		
		pedido = service.cadastrar(pedido);
		if (pedido == null) {
			fail("Pedido veio null");
		}
		assertThat(this.pedido.getEstado(), is(Estado.ABERTO));	
		assertTrue(pedido.getCliente().equals(cliente));
		assertTrue(pedido.getItens().size() == 3);

	}

	@Test
	@DisplayName("Cadastrar pedido informando cliente com um endereço, e três itens diferentes, um deles sendo negativo, e obter pedido cadastrado, com status aberto e dois itens diferentes")
	void cadastrarPedidoComVariosItensEUmNegativo() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(new BigDecimal(15)).build();
		Produto produto2 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(new BigDecimal(20)).build();
		
		fail("Pedido não usa mais Map<Produto, Integer>. Agora usa List<ItemPedido>");
		// Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		// itens.put(produto, -1);
		// itens.put(produto2, 4);

		// pedido.setItens(itens);
		
		service.cadastrar(pedido);
		
		assertThat(this.pedido.getEstado(), is(Estado.ABERTO));	
		assertTrue(service.obterQuantidadeDeItensUnicos() == 1); 

	}

	private void mockarMetodo(Pedido pedido) {
		pedido.setId( UUID.randomUUID() );
		Mockito.when(pedidoRepo.save( Mockito.any(Pedido.class) )).thenReturn( pedido );
	}

}
