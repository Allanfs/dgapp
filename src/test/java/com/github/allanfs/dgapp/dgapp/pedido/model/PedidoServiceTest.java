package com.github.allanfs.dgapp.dgapp.pedido.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Disabled
class PedidoServiceTest {
	
	@Autowired
	private PedidoServiceImpl service;
	
	@MockBean
	PedidoRepository pedidoRepo;
	
	@Test
	@DisplayName("Cadastrar pedido informando item sem quantidade")
	void cadastrarPedidoInformandoItemSemQuantidade() {
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido informando item com quantidade negativa")
	void cadastrarPedidoInformandoItemComQuantidadeNegativa() {
		// informar item com quantidade negativa
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido com dois itens, e inserir um mesmo item com quantidade negativa")
	void cadastrarPedidoComDoisItensEInserirUmItemComQuantidadeNegativa() {
		// inserir um item com quantidade maior que 1
		
		// inserir o mesmo item com quantidade -1
	}
	
	@Test
	@DisplayName("Cadastrar pedido com itens válidos")
	void cadastrarPedidoComItensValidos() {
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido com itens validos, informando pagamento menor que valor total")
	void cadastrarPedidoComItensValidosInformandoPagamentoMenorQueValorTotal() {
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido com itens validos, informando pagamento mair que valor total")
	void cadastrarPedidoComItensValidosInformandoPagamentoMaioQueValorTotal() {
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido com itens validos, informando pagamento igual valor total")
	void cadastrarPedidoComItensValidosInformandoPagamentoIgualValorTotal() {
		
	}
	
	@Test
	@DisplayName("Fechar pedido em aberto que possui pagamento igual ao valor total")
	void fecharPedidoEmAbertoQuePossuiPagamentoIgualAoValorTotal() {
		
	}
	
	@Test
	@DisplayName("Fechar pedido em aberto que possui pagamento maior que o valor total")
	void fecharPedidoEmAbertoQuePossuiPagamentoMaiorQueValorTotal() {
		
	}

	@Test
	@DisplayName("Fechar pedido em aberto que possui pagamento menor que o valor total")
	void fecharPedidoEmAbertoQuePossuiPagamentoMenorQueValorTotal() {
		
	}
	
}
