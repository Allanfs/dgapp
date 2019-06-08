package com.github.allanfs.dgapp.dgapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.repository.TamanhoRepository;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Métodos definidos na interface TamanhoRepository")
public class TamanhoRepositoryTests {

	@Autowired
    private TamanhoRepository tamanhoRepo;

	@DisplayName("Buscar tamanho por nome")
	@ParameterizedTest(name = "Buscar tamanho de nome: {0}" )
	@CsvSource(value = {"Pequena, 25, 4, 17","Média, 30, 6, 22","Grande, 35, 8, 29"})
	public void buscaNomeExistente(String nome, int centimetros, int numeroFatias, float preco)  {
		
		Tamanho tamanhoAtual = tamanhoRepo.findByNome(nome).get();
		assertNotNull( tamanhoAtual );
		
		assertEquals(nome, tamanhoAtual.getNome());
		assertEquals(centimetros, tamanhoAtual.getCentimetros());
		assertEquals(numeroFatias, tamanhoAtual.getNumeroFatias());
		assertEquals(preco, tamanhoAtual.getPrecoPadrao());
		
	}
	
	@DisplayName("Buscar tamanho por nome que não existe")
	@Test
	public void buscaNomeNaoExistente(){
		
		Tamanho tamanhoAtual = tamanhoRepo.findByNome("Pão").get();
		assertNull( tamanhoAtual );
		
	}

}
