package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CadastrarPedidoTest {

	@MockBean
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PedidoServiceImpl service;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void cadastrarPedidoVazio() {
		
		Pedido pedido = new Pedido();
		
		mockarMetodo(pedido);
		
		assertThrows(ClienteNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	void cadastrarPedidoApenasComCliente() {
		
		Pedido pedido = new Pedido();
		
		Cliente cliente = new Cliente();
		
		pedido.setCliente(cliente);
		
		mockarMetodo(pedido);
		
		assertThrows(EnderecoNaoInformadoException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	void cadastrarPedidoComUmEnderecoQueNaoReferenciaCliente() {
		
		Pedido pedido = new Pedido();
		
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		mockarMetodo(pedido);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido));
				
	}
	
	@Test
	void cadastrarPedidoComUnicoItemNegativo() {
		Pedido pedido = new Pedido();
		
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		
		Produto produto = new Produto();
		produto.setId(UUID.randomUUID());
		produto.setNome("produto 1");
		produto.setPreco(10);
		
		
		ItemPedido item = new ItemPedido(pedido,produto);
		
		service.setPedido(pedido);
		service.adicionarItem(produto);
		
		pedido.getItens().put(produto, -1);
		
		mockarMetodo(pedido);
		
		assertThrows(PedidoSemItensException.class, () -> service.cadastrar(pedido) ); 

	}
	
	@Test
	void cadastrarPedidoComVariosItensEUmNegativo() {
		Pedido pedido = new Pedido();
		
		Cliente cliente = new Cliente();
		
		Endereco endereco = new Endereco();
		
		cliente.getEndereco().add(endereco);
		
		pedido.setCliente(cliente);
		
		
		Produto produto = new Produto();
		produto.setId(UUID.randomUUID());
		produto.setNome("produto 1");
		produto.setPreco(10);
		
		Produto produto2 = new Produto();
		produto2.setId(UUID.randomUUID());
		produto2.setNome("produto 1");
		produto2.setPreco(10);
		
		service.setPedido(pedido);
		service.adicionarItem(produto);		
		service.adicionarItem(produto2);
		
		pedido.getItens().put(produto, -1);
		
		mockarMetodo(pedido);
		
		service.cadastrar(pedido);
		
		assertTrue(service.obterQuantidadeDeItensUnicos() == 1); 

	}
	

	private void mockarMetodo(Pedido pedido) {
		pedido.setId( UUID.randomUUID() );
		Mockito.when(pedidoRepo.save( Mockito.any(Pedido.class) )).thenReturn( pedido );
	}

}
