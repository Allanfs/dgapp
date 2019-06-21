package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.allanfs.dgapp.dgapp.pedido.service.Numerario;

class PedidoNovoTest {
	
	PedidoNovo pedido;
	Produto produto1, produto2;
	int valorProduto1 = 20;
	int valorProduto2 = 10;

	PedidoNovoService pedidoService;
	
	@BeforeEach
	public void setUp() {
		pedido = new PedidoNovo();

		produto1 = new Produto();
		produto1.setNome("Refrigerante 1L");
		produto1.setValor(new Numerario(valorProduto1));
		
		produto2 = new Produto();
		produto2.setNome("Paçoca");
		produto2.setValor(new Numerario(valorProduto2));
		
		pedidoService = new PedidoNovoService();
		pedidoService.setPedido(pedido);
		
	}
	
	@Test
	@DisplayName("Adicionar um item no pedido, e verificar a quantidade de itens presente")
	void testAdicionarItem() {
		
		assertEquals(0, pedido.getItens().size());
		
		pedidoService.adicionarItem(produto1);
		
		assertTrue(pedido.getItens().get(produto1).equals(1));
		assertTrue(pedido.getItens().size() == 1);
		
		pedidoService.adicionarItem(produto2);
		
		assertTrue(pedido.getItens().get(produto1).equals(1));
		assertTrue(pedido.getItens().size() == 2);
		
		pedidoService.adicionarItem(produto1);
		
		assertTrue(pedido.getItens().get(produto1).equals(2));
		assertTrue(pedido.getItens().size() == 2);
		
	}
	
	@Test
	@DisplayName("Adicionar itens no pedido, e verificar a quantidade de itens unicos presente")
	void testObterQuantidadeDeItensUnicos() {
		
		int quantidadeItem = 3;
		for (int i = 0; i < quantidadeItem; i++) {
			pedidoService.adicionarItem(produto1);
			
		}
		pedidoService.adicionarItem(produto2);
		
		assertTrue(pedidoService.obterQuantidadeDeItensUnicos() == 2);
	}
	
	@Test
	@DisplayName("Adicionar itens no pedido, e verificar a quantidade de itens presente")
	void testObterQuantidadeDeItens() {
		
		int quantidadeItem = 3;
		for (int i = 0; i < quantidadeItem; i++) {
			pedidoService.adicionarItem(produto1);
			
		}
		pedidoService.adicionarItem(produto2);
		
		assertTrue(pedidoService.obterQuantidadeDeItens() == 4);
	}

	@Test
	@DisplayName("Remover uma unidade de item do pedido, e verificar a quantidade restante ser menor que a quantidade inserida")
	void testRemoverUmItem() {
		
		int quantidadeItem = 3;
		for (int i = 0; i < quantidadeItem; i++) {
			pedidoService.adicionarItem(produto1);
			
		}
		
		pedidoService.adicionarItem(produto2);
		pedidoService.adicionarItem(produto2);
		
		pedidoService.removerUmItem(produto1);
		
		assertTrue(quantidadeItem -1  == pedido.getItens().get(produto1));
		
	}

	@Test
	@DisplayName("Remover todas as unidades de um item no pedido, e verificar que ele não está mais presente")
	void testRemoverItem() {
		int quantidadeItem = 3;
		for (int i = 0; i < quantidadeItem; i++) {
			pedidoService.adicionarItem(produto1);
			
		}
		
		pedidoService.adicionarItem(produto2);
		pedidoService.adicionarItem(produto2);
		
		pedidoService.removerItem(produto1);
		
		assertNull(pedido.getItens().get(produto1));
	}

	@Test
	@DisplayName("Calcular o valor de todos os itens presentes no pedido, e verificar que é a soma dos valores com as quantidades dos itens")
	void testCalcularSubtotal() {
		int quantidadeItem = 3;
		for (int i = 0; i < quantidadeItem; i++) {
			pedidoService.adicionarItem(produto1);
			
		}
		
		for (int i = 0; i < quantidadeItem; i++) {
			
			pedidoService.adicionarItem(produto2);
		}
		
		Numerario valorEsperado = new Numerario(valorProduto1 + valorProduto2)
				.vezes(new Numerario(quantidadeItem));
		
		assertEquals( valorEsperado, pedidoService.calcularSubtotal() );
	}

	@Test
	@DisplayName("Calcular valor do pedido incluindo valores de desconto e acrescimo")
	void testCalcularTotal() {
		int valorDesconto = 5;
		Operacao desconto1 = Operacao.DESCONTO.setValor(valorDesconto);
		
		pedidoService.adicionarDesconto(desconto1);
		
		Numerario valor= new Numerario( desconto1.getValor() );
		
		assertTrue(pedidoService.calcularTotal().equals(new Numerario(desconto1.getValor())));
		
		pedidoService.adicionarItem(produto1);
		
		Numerario totalEsperado = produto1.getValor().mais(valor);
		assertTrue( pedidoService.calcularTotal().equals( totalEsperado ) );
		
		
		
		Operacao cobranca1 = Operacao.COBRANCA.setValor(valorDesconto);
		
		pedidoService.adicionarCobranca(cobranca1);
		
		Numerario valorCobranca = new Numerario(cobranca1.getValor());
		totalEsperado = produto1.getValor().mais(valor).mais(valorCobranca);
		assertTrue( pedidoService.calcularTotal().equals( totalEsperado ) );
		
	}

	@Test
	@DisplayName("Fechar um pedido")
	void testFecharPedido() {
		fail("Not yet implemented");
	}

}
