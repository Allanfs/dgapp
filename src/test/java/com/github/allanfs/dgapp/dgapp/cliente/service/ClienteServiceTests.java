package com.github.allanfs.dgapp.dgapp.cliente.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClienteServiceTests {

	@Autowired
	private ClienteService service;
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/cadastrarCliente.csv",numLinesToSkip=1)
	@DisplayName("Cadastrar um cliente com sucesso")
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
	void adicionarTelefoneAoClienteTest(String ddd,String numero,String whatsapp,String observação,String id_cliente) {
		//service.adicionarTelefone(telefone);
		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/removerTelefoneDeCliente.csv",numLinesToSkip=1)
	@DisplayName("Remover um telefone do cliente")
	void removerUmTelefoneAoClienteTest() {
		//service.removerEndereco(Endereco);
		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/editarTelefoneDoCliente.csv",numLinesToSkip=1)
	@DisplayName("Editar um telefone do cliente")
	void editarUmTelefoneAoClienteTest() {
		//service.alterarTelefone(telefone);
		fail("Not yet implemented");
	}
	
	@Test
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/adicionarEnderecoAoCliente.csv",numLinesToSkip=1)
	@DisplayName("Cadastar um novo endereco ao cliente")
	void cadastrarUmEnderecoAoClienteTest() {
		//service.adicionarEndereceo(endereco);
		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cliente/removerEnderecoDoCliente.csv",numLinesToSkip=1)
	@DisplayName("Remover um endereco do cliente")
	void removerUmEnderecoDoClienteTest() {
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
