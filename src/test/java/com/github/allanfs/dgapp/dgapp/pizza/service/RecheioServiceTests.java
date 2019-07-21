package com.github.allanfs.dgapp.dgapp.pizza.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste de Serviço de Recheio")
public class RecheioServiceTests {

	@Autowired
	private RecheioService service;
	
	@Test
	@DisplayName("Cadastrar um recheio")
	void cadastrarRecheio() {
		
		Recheio recheioNovo = new Recheio();
		String nomeSabor = "Sabor Novo";
		recheioNovo.setNome(nomeSabor);
		recheioNovo.setEhDisponivel(false);
		recheioNovo.setEhEspecial(false);
		recheioNovo.setEhSalgado(true);
		
		recheioNovo = service.cadastrar(recheioNovo);
		
		assertNotNull(recheioNovo.getId());
		assertEquals(nomeSabor, recheioNovo.getNome() );
	}
	
	@ParameterizedTest
	@DisplayName("Buscar um recheio por ID")
	@CsvSource(delimiter = ',', value = {"a5fb0b8c-8a2e-11e9-bc42-526af7764f64, Mussarela, false, true, true"})
	void buscarRecheio(String id, String nome, boolean ehEspecial, boolean ehDisponivel, boolean ehSalgado) {
		
		UUID uid = UUID.fromString(id);
		Recheio recheioEsperado = new Recheio(uid, nome);
		recheioEsperado.setEhDisponivel(ehDisponivel);
		recheioEsperado.setEhEspecial(ehEspecial);
		recheioEsperado.setEhSalgado(ehSalgado);
		
		Recheio recheioAtual = service.buscarPorId(recheioEsperado.getId());
		
		assertTrue(recheioAtual.equals(recheioEsperado));
		
	}
	
	@Test
	@DisplayName("Editar um recheio")
	void editarRecheio() {
		UUID uid = UUID.fromString("a5fb0a60-8a2e-11e9-bc42-526af7764f64");
		
		// Recheio existente no banco
		Recheio recheioAtual = service.buscarPorId(uid);
		
		// Recheio atualizado
		Recheio recheioAlterar = new Recheio(uid, "Molho");
		recheioAlterar.setEhDisponivel(false);
		recheioAlterar.setEhEspecial(false);
		recheioAlterar.setEhSalgado(true);
		
		recheioAlterar = service.editar(recheioAlterar);
		
		assertFalse(recheioAtual.equals(recheioAlterar));
		
	}
	
	@Test
	@DisplayName("Excluir recheio por seu ID")
	void excluirRecheio() {
		
		String uuid = "a5fb0a60-8a2e-11e9-bc42-526af7764f64";
		
		UUID UID = UUID.fromString(uuid);
		
		assertNotNull( service.buscarPorId(UID) );
		
		service.deletar(UID);
		
		assertThrows(EntityNotFoundException.class, () -> service.buscarPorId(UID));
		
	}
}
