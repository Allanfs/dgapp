package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.exparity.hamcrest.date.DateMatchers.isToday;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
class FecharPedidoTest {

	@MockBean
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PedidoServiceImpl service;
	
	private Pedido pedido;
	
	@BeforeEach
	void setUp() throws Exception {
		pedido = new Pedido();
		service.setPedido(this.pedido);
		
	}

	@Test
	void cancelarPedido() {
		
		Pedido pedidoCancelado = service.cancelarPedido();
		
		Assertions.assertTrue(pedidoCancelado.getHoraFechamento() != null);
		assertThat(pedidoCancelado.getHoraFechamento(), isToday());
		
	}

}
