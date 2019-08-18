//package com.github.allanfs.dgapp.dgapp.pedido.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
//import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
//import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
//import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;
//import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoException;
//import com.github.allanfs.dgapp.dgapp.pizza.model.ProdutoPizza;
//import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
//import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
//
//@SpringJUnitConfig
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//class CadastrarItensNoPedidoTest {
//	
//	@MockBean
//	private PedidoRepository pedidoRepo;
//	
//	@Autowired
//	private PedidoServiceImpl service;
//	
//	private Pedido pedido;
//
//	private List<ItemPedidoSabor> saboresDaPizza;
//
//	private ProdutoPizza pizza;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//		this.pedido = new Pedido();
//		
//		Cliente cliente = new Cliente();
//		
//		Endereco endereco = new Endereco();
//		
//		cliente.getEndereco().add(endereco);
//		
//		pedido.setCliente(cliente);
//		
//		saboresDaPizza = new ArrayList<ItemPedidoSabor>();
//		
//		pizza = new ProdutoPizza();
//		pizza.setNome("pizza");
//		pizza.setPreco(new BigDecimal(20));
//		pizza.setTamanho(
//				Tamanho.builder().id(UUID.randomUUID()).centimetros(10).numeroFatias(2).nome("modelo teste").build());
//
//		mockarMetodo(pedido);
//	}
//
//	@Test
//	@DisplayName("Inserir pizza válida no pedido")
//	void inserirPizzaValidaNoPedido() {
//		saboresDaPizza = new ArrayList<ItemPedidoSabor>();
//		
//		saboresDaPizza.add(new ItemPedidoSabor(pedido, pizza, Sabor.builder().nome("Teste").build()));
//		
//		pizza.setSabores(saboresDaPizza);
//		
//		ItemPedido itemPizza = new ItemPedido(pedido, pizza);
//		
//		List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();
//		itensDoPedido.add(itemPizza);
//		pedido.setItens(itensDoPedido);
//		PedidoException pe = assertThrows(PedidoException.class, () -> service.cadastrar(pedido));
//		assertTrue(pe.getMessage().contains("Quantidade de sabores maior que a permitida para o tamanho"));
//	}
//	
//	@Test
//	@DisplayName("Inserir pizza sem tamanho, e obter PedidoException")
//	void inserirPizzaSemTamanho() {
//		
//		pizza.setTamanho(null);
//		
//		ItemPedido itemPizza = new ItemPedido(pedido, pizza);
//		
//		List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();
//		itensDoPedido.add(itemPizza);
//		pedido.setItens(itensDoPedido);
//		PedidoException pe = assertThrows(PedidoException.class, () -> service.cadastrar(pedido));
//		assertEquals("Tamanho da pizza não informado.", pe.getMessage());
//	}
//	
//	@Test
//	@DisplayName("Inserir pizza sem sabores, e obter PedidoException")
//	void inserirPizzaSemSabores() {
//		
//		ItemPedido item = new ItemPedido(pedido, pizza);
//		
//		List<ItemPedido> itens = new ArrayList<ItemPedido>();
//		itens.add(item);
//		pedido.setItens(itens);
//		assertThrows(PedidoException.class, () -> service.cadastrar(pedido));
//		
//	}
//	
//	@Test
//	@DisplayName("Inserir pizza com mais sabores que o sabor permite, e obter PedidoException")
//	void inserirPizzaComMaisSaboresDoQuePermitidoNoTamanho() {
//		
//		pizza.setTamanho(
//				Tamanho.builder().id(UUID.randomUUID()).centimetros(10).numeroFatias(1).nome("modelo teste").build());
//		
//		saboresDaPizza.add(new ItemPedidoSabor(pedido, pizza, Sabor.builder().nome("Teste").build()));
//		saboresDaPizza.add(new ItemPedidoSabor(pedido, pizza, Sabor.builder().nome("Teste1").build()));
//		
//		pizza.setSabores(saboresDaPizza);
//		
//		ItemPedido itemPizza = new ItemPedido(pedido, pizza);
//		
//		List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();
//		itensDoPedido.add(itemPizza);
//		pedido.setItens(itensDoPedido);
//		PedidoException pe = assertThrows(PedidoException.class, () -> service.cadastrar(pedido));
//		assertTrue(pe.getMessage().contains("Quantidade de sabores maior que a permitida para o tamanho"));
//		
//	}
//	
//	private void mockarMetodo(Pedido pedido) {
//		pedido.setId( UUID.randomUUID() );
//		Mockito.when(pedidoRepo.save( Mockito.any(Pedido.class) )).thenReturn( pedido );
//	}
//
//}
