package com.github.allanfs.dgapp.dgapp.pedido.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.service.ClienteService;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoServiceImpl;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.postgresql.jdbc2.optional.SimpleDataSource;

//@SpringJUnitConfig
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PedidoServiceTest {
	
	Cliente cliente;
	Endereco endereco;
	Set<ItemPedido> itens;
	
	@BeforeEach
	void beforeEach() {
		
	}

	@Test
	@DisplayName("Cadastrar um pedido e obter seu número")
	void test() throws ParseException {
		
		Cliente cliente = null;
		// inserir endereço do cliente
		// inserir telefone do cliente
		// inserir um item no pedido

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		
		PedidoServiceImpl service = new PedidoServiceImpl();
		
		// mockar o repository usado no PedidoService
		// quando chamar um metodo do repo, retornar um valor...

		String numeroRetornado = pedido.getNumero();


		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
		
		StringBuilder sb = new StringBuilder( sdf.format( Calendar.getInstance().getTime() ) );

		sb.append("001");

		Assertions.assertEquals(sb.toString(), numeroRetornado);

		
	}

	@ParameterizedTest
	@ValueSource(strings = {"", ""})
	@DisplayName("Cadastrar pedido com cliente que possui apenas um endereço")
	void cadastrarPeidoComClienteQuePossuiUmEndereco( String idCliente, String idEndereco) {
		
		Cliente cliente = null;
		Endereco enderecoDoCliente = null;
		
		ClienteService cs = new ClienteService();
		
		cliente = cs.adicionarEndereceo(enderecoDoCliente, cliente);
		
		Pedido pedido1 = new Pedido();
		
		pedido1.setCliente(cliente);
		
		PedidoServiceImpl pedidoService = new PedidoServiceImpl();
		pedidoService.setPedido(pedido1);
		
		pedido1 = pedidoService.cadastrar();
		
		assertTrue( pedido1.getEndereco().equals(enderecoDoCliente) );
		assertTrue( pedido1.getEstado().estaAberto() );
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido com cliente que possui mais de um endereço")
	void cadastraPedidoComClienteQuePossuiMaisDeUmEndereco() {
		Cliente cliente = null;
		
		Set<Endereco> enderecosCliente = null;
		
		cliente.setEndereco(enderecosCliente);
			
		Pedido pedido1 = new Pedido();
		
		pedido1.setCliente(cliente);
		
		PedidoServiceImpl pedidoService = new PedidoServiceImpl();
		pedidoService.setPedido(pedido1);
		
		assertThrows(EnderecoNaoInformadoException.class, () -> pedidoService.cadastrar());
		
	}
	
	@Test
	@DisplayName("Cadastrar pedido sem informar itens")
	void cadastrarPedidoSemInformarItens() {
		Cliente cliente = null;
		Endereco enderecoDoCliente = null;
		
		Pedido pedido1 = new Pedido();
		
		pedido1.setCliente(cliente);
		
		PedidoServiceImpl pedidoService = new PedidoServiceImpl();
		pedidoService.setPedido(pedido1);
		
		assertThrows(PedidoSemItensException.class, () -> pedidoService.cadastrar() );
		
	}
	
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
