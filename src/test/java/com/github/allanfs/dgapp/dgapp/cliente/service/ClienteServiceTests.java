package com.github.allanfs.dgapp.dgapp.cliente.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClienteServiceTests {

	@Autowired
	private ClienteService service;
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/cadastrarCliente.csv",numLinesToSkip=1)
	@DisplayName("Cadastrar um cliente sem informar telefone e endereço")
	void cadastrarClienteTest(String nome,Long dataNascimento, String cpf, String instagram, String facebook, String email) {
		
		Date dn = null;
		
		if(dataNascimento != null) {
			dn = new Date(dataNascimento);
		}
		
		Cliente cliente = Cliente.builder()
				.nome(nome)
				.cpf(cpf)
				.instagram(instagram)
				.facebook(facebook)
				.email(email)
				.dataNascimento(dn)
				.build();
		
		Cliente cNovo = service.cadastrar(cliente);
		
		assertNotNull(cNovo.getId());
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/adicionarTelefoneAoCliente.csv",numLinesToSkip=1)
	@DisplayName("Cadastrar um novo telefone ao cliente")
	void adicionarTelefoneAoClienteTest(String ddd,String numero,boolean whatsapp,String observacao,String id_cliente) {
		
		UUID idCliente = UUID.fromString(id_cliente);
		Telefone telefone = Telefone.builder()
				.ddd(new Integer(ddd)).numero(numero).whatsapp(whatsapp)
				.observacao(observacao)
				.cliente(Cliente.builder().id(idCliente).build())
				.build();
		
		Cliente cliente = service.buscarPorId(idCliente);
		
		Cliente clienteComNovoTelefone = service.cadastrarTelefone(cliente, telefone);
		
		assertTrue(clienteComNovoTelefone.getTelefone().contains(telefone));
		assertNotNull(clienteComNovoTelefone.getId());
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/removerTelefoneDeCliente.csv",numLinesToSkip=1)
	@DisplayName("Remover um telefone do cliente")
	void removerUmTelefoneAoClienteTest(String idTelefone, String idCliente) {
		
		Telefone telefone = Telefone.builder().id(UUID.fromString(idTelefone)).build();
		Cliente cliente = Cliente.builder().id(UUID.fromString(idCliente)).build();
		
		int quantidadeDeTelefonesAntes = cliente.getTelefone().size();
		
		service.removerTelefone(telefone, cliente);
		assertFalse(cliente.getTelefone().contains(telefone));
		
		int quantidadeDeTelefonesDepois = cliente.getTelefone().size();
		
		assertTrue( quantidadeDeTelefonesAntes > quantidadeDeTelefonesDepois);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/editarTelefoneDoCliente.csv",numLinesToSkip=1)
	@DisplayName("Editar um telefone do cliente")
	void editarUmTelefoneAoClienteTest() {
		//service.alterarTelefone(telefone);
		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/adicionarEnderecoAoCliente.csv",numLinesToSkip=1)
	@DisplayName("Cadastar um novo endereco ao cliente")
	void cadastrarUmEnderecoAoClienteTest(String rua, String numero, String bairro, String complemento, String idCliente) {
		
		Cliente cliente = Cliente.builder().id( UUID.fromString(idCliente) ).build();
		Endereco novoEndereco = Endereco.builder().rua(rua).numero(numero).bairro(bairro).complemento(complemento).cliente(cliente ).build();
		
		service.adicionarEndereceo(novoEndereco, cliente);
		
		assertTrue(cliente.getEndereco().contains(novoEndereco));
		assertNotNull(novoEndereco.getId());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/removerEnderecoDoCliente.csv",numLinesToSkip=1)
	@DisplayName("Remover um endereco do cliente")
	void removerUmEnderecoDoClienteTest(String idEndereco, String idCliente) {
		
		UUID enderecoId = UUID.fromString(idEndereco);
		UUID clienteId = UUID.fromString(idCliente);
		
		
		
		//service.removerEndereco(endereco);
		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/editarEnderecoDoCliente.csv",numLinesToSkip=1)
	@DisplayName("Editar um endereco do cliente")
	void editarUmEnderecoDoClienteTest() {
		fail("Not yet implemented");
	}

}
