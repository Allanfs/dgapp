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
	void cadastrarClienteTest(String nome, Long dataNascimento, String cpf, String insta, String email) {
		
		Date dn = null;
		
		if(dataNascimento != null) {
			dn = new Date(dataNascimento);
		}
		
		Cliente cliente = Cliente.builder()
				.nome(nome)
				.email(email)
				.cpf(cpf)
				.instagram(insta)
				.dataNascimento(dn)
				.build();
		
		Cliente cNovo = service.cadastrar(cliente);
		
		assertNotNull(cNovo.getId());
		
	}
	
	@Test
	@DisplayName("Cadastrar um cliente sem informar telefone e endereço")
	void cadastrarClienteSemItnformarTelefoneEEnderecoTest() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Cadastrar um novo telefone ao cliente")
	void adicionarTelefoneAoClienteTest() {
		//service.adicionarTelefone(telefone);
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Remover um telefone do cliente")
	void removerUmTelefoneAoClienteTest() {
		//service.removerEndereco(Endereco);
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Editar um telefone do cliente")
	void editarUmTelefoneAoClienteTest() {
		//service.alterarTelefone(telefone);
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Cadastar um novo endereco ao cliente")
	void cadastrarUmEnderecoAoClienteTest() {
		//service.adicionarEndereceo(endereco);
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Remover um endereco do cliente")
	void removerUmEnderecoDoClienteTest() {
		//service.removerEndereco(endereco);
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Editar um endereco do cliente")
	void editarUmEnderecoDoClienteTest() {
		fail("Not yet implemented");
	}

}
