package com.github.allanfs.dgapp.dgapp.pizza.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste de Serviço de Recheio")
public class RecheioServiceTests {

	@Autowired
	private RecheioService service;
	
	@Test
	@DisplayName("Excluir recheio por seu UUID")
	void excluirRecheio() {
		
		String uuid = "a5fb0b8c-8a2e-11e9-bc42-526af7764f64";
		
		UUID UID = UUID.fromString(uuid);
		
		assertNotNull( service.buscarPorId(UID) );
		
		service.deletar(UID);
		
		assertThrows(EntityNotFoundException.class, () -> service.buscarPorId(UID));
		
	}
}
