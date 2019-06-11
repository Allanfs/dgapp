package com.github.allanfs.dgapp.dgapp.cliente.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EnderecoServiceTests {

	@Test
	@DisplayName("Cadastrar um endereço, indicando o cliente que o possui")
	void atest() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Cadastrar um endereço, sem informar o cliente que o possui")
	void btest() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Editar um endereço")
	void ctest() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Excluir em endereço")
	void test() {
		fail("Not yet implemented");
	}
	
}
