package com.github.allanfs.dgapp.dgapp.pizza.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste de Serviço de Recheio")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TamanhoServiceTests {

	@Autowired
	private TamanhoService service;
	
	Tamanho tamanho = new Tamanho(null, "Brotinho", 2, 1, 10, 10f); 
	static Tamanho novoTamanho;
	
	@Test
	@DisplayName("Cadastrar um recheio")
	void aTest() {
		
		novoTamanho = service.cadastrar(tamanho);
		
		assertNotNull(novoTamanho.getId());
		assertEquals(tamanho.getNome(), novoTamanho.getNome() );
	}
	
	@Test
	@DisplayName("Buscar um tamanho por ID")
	void bTest() {
		
		Tamanho tamanhoEncontrado = service.buscarPorId(novoTamanho.getId());
		service.buscarPorNome(novoTamanho.getNome());
		assertTrue(tamanhoEncontrado.equals(novoTamanho));
		
	}
	
	@Test
	@DisplayName("Buscar um tamanho por nome")
	void cTest() {
		
		Tamanho tamanhoEncontrado = service.buscarPorNome(tamanho.getNome());
		assertTrue(tamanhoEncontrado.equals(novoTamanho));
		
	}
	
	@Test
	@DisplayName("Editar um tamanho")
	void yTest() {
		
		String novoNome = "Pequeno Brotinho";
		
		novoTamanho.setNome(novoNome);
		
		Tamanho tamanhoEditado = service.editar(novoTamanho);
		
		assertTrue(tamanhoEditado.getNome().equals(novoNome));
		assertTrue(tamanhoEditado.equals(novoTamanho));
		
	}
	
	@Test
	@DisplayName("Excluir tamanho por seu ID")
	void zTest() {
		
		UUID UID = novoTamanho.getId();
		
		assertNotNull( service.buscarPorId(UID) );
		
		service.deletar(UID);
		
		assertThrows(EntityNotFoundException.class, () -> service.buscarPorId(UID));
		
	}
}
