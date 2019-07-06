package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import org.junit.jupiter.api.BeforeEach;
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
	void cadastrarPedidoVazio() {
		
		assertThrows(ClienteNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	void cadastrarPedidoApenasComCliente() {
		
		Cliente cliente = new Cliente();
		
		pedido.setCliente(cliente);
		
		assertThrows(EnderecoNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	void cadastrarPedidoApenasComEndereco() {
		
		Endereco endereco = new Endereco();
		
		pedido.setEndereco(endereco);
		
		assertThrows(ClienteNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
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
	void cadastrarPedidoSemItensComClienteComMaisDeUmEndereco() {

		Cliente cliente = new Cliente();
		HashSet<Endereco> enderecos = new HashSet<Endereco>();
		enderecos.add(Endereco.builder().cliente(cliente).build());
		enderecos.add(Endereco.builder().cliente(cliente).build());
		cliente.setEndereco(enderecos);

		pedido.setCliente(cliente);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido));
		
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
	void cadastrarPedidoComUnicoItemNegativo() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(10).build();
		
		Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		itens.put(produto, -1);
		pedido.setItens(itens);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido) ); 

	}
	
	@Test
	void cadastrarPedidoComItensComQuantidadePositiva() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(10).build();
		Produto produto1 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(15).build();
		Produto produto2 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(20).build();
		
		Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		itens.put(produto, 1);
		itens.put(produto1, 3);
		itens.put(produto2, 4);
		pedido.setItens(itens);
		
		
		pedido = service.cadastrar(pedido);
		if (pedido == null) {
			fail("Pedido veio null");
		}
		assertTrue(pedido.getCliente().equals(cliente));
		assertTrue(pedido.getItens().size() == 3);

	}

	@Test
	void cadastrarPedidoComVariosItensEUmNegativo() {
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		Produto produto = Produto.builder().id(UUID.randomUUID()).nome("produto 1").preco(10).build();
		Produto produto2 = Produto.builder().id(UUID.randomUUID()).nome("produto 2").preco(20).build();
		
		Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
		itens.put(produto, -1);
		itens.put(produto2, 4);

		pedido.setItens(itens);
		
		service.cadastrar(pedido);
		
		assertTrue(service.obterQuantidadeDeItensUnicos() == 1); 

	}

	private void mockarMetodo(Pedido pedido) {
		pedido.setId( UUID.randomUUID() );
		Mockito.when(pedidoRepo.save( Mockito.any(Pedido.class) )).thenReturn( pedido );
	}

}
