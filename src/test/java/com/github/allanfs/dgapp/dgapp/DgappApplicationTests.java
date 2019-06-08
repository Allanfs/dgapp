package com.github.allanfs.dgapp.dgapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.controllers.TamanhoController;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DgappApplicationTests {

	@Autowired
	private TamanhoController controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	/**
	 * Verifica se obtem resposta dos endpoints
	 */
	@DisplayName("Testa existencia dos controllers")
	@ParameterizedTest
	@ValueSource(strings = {"tamanho","recheio","sabor"})
	public void verificaExistenciaDosEndpoint(String endpoint) throws Exception {
		
		String urlPart = String.format("http://localhost:%d/", port);
		
		String URL = urlPart + endpoint;
		
		assertEquals( HttpStatus.OK ,this.restTemplate.getForEntity(URL, Object.class).getStatusCode() );
		
	}

}
