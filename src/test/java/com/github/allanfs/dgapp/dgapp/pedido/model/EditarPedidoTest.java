package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.CancelamentoDePedidoException;

/**
 * EditarPedidoTest
 */
@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EditarPedidoTest {

	@MockBean
	private PedidoRepository pedidoRepo;

	@Autowired
	private PedidoServiceImpl service;

	private Pedido pedido;

	void setUp() {
		service.setPedido(this.pedido);
	}
	
	@Test
	@DisplayName("Alterar endereço de um pedido em aberto")
	void alterarEnderecoDeUmPedidoEmAberto(){
		Pedido pedido = new Pedido();
		pedido.setEstado(Estado.ABERTO);
		Endereco novoEndereco = Endereco.builder().id(UUID.randomUUID()).build();
		
		service.adicionarEndereco(pedido, novoEndereco);

		assertThat( pedido.getEndereco(), is(equalTo(novoEndereco)) );
		
	}
	
	@Disabled
	@Test
	void adicionarPagamento() {
		Pedido pedido = null; // criar um pedido
		FormaDePagamento pagamento = null;

		service.adicionarPagamento(pedido, pagamento);

		assertThat(pedido.getPagamento(), is(Matchers.notNullValue()));
		assertEquals(pedido.getPagamento(), pagamento);
		
	}

	@Test
	@DisplayName("Cancelar pedido informando motivo do cancelamento, e obter pedido cancelado.")
	void cancelarPedidoInformandoMotivo(){
		Pedido pedido = new Pedido();
		pedido.setEstado(Estado.ABERTO);
		pedido.setId(UUID.randomUUID());
		pedido.setCliente(Cliente.builder().id(UUID.randomUUID()).build());
		pedido.setEndereco(Endereco.builder().id(UUID.randomUUID()).build());

		String motivoCancelamento = "cliente desistiu por causa da demora";

		pedido.setMotivoCancelamento(motivoCancelamento);	
		
		mockarMetodo(pedido);
		
		service.cancelarPedido(pedido);

		assertThat(pedido.getEstado(), is(Estado.CANCELADO));
		
	}

	@Test
	@DisplayName("Cancelar pedido sem informar motivo, e obter CancelamentoDePedidoException.")
	void cancelarPedidoSemInformarMotivo(){
		Pedido pedido = new Pedido();
		pedido.setEstado(Estado.ABERTO);
		pedido.setId(UUID.randomUUID());
		pedido.setCliente(Cliente.builder().id(UUID.randomUUID()).build());
		pedido.setEndereco(Endereco.builder().id(UUID.randomUUID()).build());

		assertThrows(CancelamentoDePedidoException.class, () -> service.cancelarPedido(pedido) );
		
	}
	
	private void mockarMetodo(Pedido pedido) {
		pedido.setId( UUID.randomUUID() );
		Mockito.when(pedidoRepo.save( Mockito.any(Pedido.class) )).thenReturn( pedido );
	}
	
}