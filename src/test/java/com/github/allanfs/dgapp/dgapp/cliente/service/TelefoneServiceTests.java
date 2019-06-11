package com.github.allanfs.dgapp.dgapp.cliente.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TelefoneServiceTests {

	@Autowired
	private TelefoneService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	@DisplayName("Cadastrar telefone, indicando o cliente que o posui")
	void aTest() {
		
	}
	
	@Test
	@DisplayName("Cadastrar telefone, sem indicar o cliente que o possui")
	void bTest() {
		
	}
	
	@Test
	@DisplayName("Editar os dados de um telefone")
	void cTest() {
		
	}
	
	@Test
	@DisplayName("Buscar um telefone pesquisando pelo cliente que o possui")
	void dTest() {
		
	}
	
	@Test
	@DisplayName("Buscar um telefone pelo seu número")
	void eTest() {
		
	}
	
	@Test
	@DisplayName("Excluir um telefone informando seu id")
	void fTest() {
		
	}
	
	@Test
	@DisplayName("Excluir um telefone informando seu número")
	void gTest() {
		
	}
	
	@Test
	@DisplayName("Excluir todos os telefones de um cliente")
	void hTest() {
		
	}
	
}
