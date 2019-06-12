package com.github.allanfs.dgapp.dgapp.pizza.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.SaborOrdemRecheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.SaborPrecoTamanho;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Teste de Serviço de Recheio")
public class SaborServiceTests {

	@Autowired
	private SaborService service;
	
	static Sabor saborCadastrado;
	
	@Test
	@DisplayName("Cadastrar um sabor sem informar o preço nos tamanhos")
	void aTest() {
		
		Sabor saborNovo = new Sabor();
		
		String nomeSabor = "Presunto";
		saborNovo.setNome(nomeSabor);
		saborNovo.setEhDisponivel(true);
		saborNovo.setEhEspecial(true);
		saborNovo.setEhSalgado(true);
		
		String idMolho = "a5fad176-8a2e-11e9-bc42-526af7764f64";
		Recheio molho = new Recheio(UUID.fromString(idMolho), null);
		Recheio mussarela = new Recheio(UUID.fromString("a5facf00-8a2e-11e9-bc42-526af7764f64"), null);
		Recheio presunto = new Recheio(UUID.fromString("a5fad95a-8a2e-11e9-bc42-526af7764f64"), null);
		
		criarSetDeRecheios(saborNovo, molho, mussarela,presunto);
		
		saborCadastrado = service.cadastrar(saborNovo);
		
		assertNotNull(saborCadastrado.getId());
		assertEquals(nomeSabor, saborCadastrado.getNome() );
		assertNotNull(saborCadastrado.getPrecos());
		
		assertTrue(service.recheioExisteNoSabor(UUID.fromString(idMolho), saborCadastrado));
	}

	@Test
	@DisplayName("Cadastrar um sabor sem recheio e apenas um tamanho, então receber sabor com todos os tamanhos")
	void cadastraSemRecheio() {
		
		Tamanho tamanho = new Tamanho();
			tamanho.setId(UUID.fromString("d134a92e-889f-11e9-bc42-526af7764f64"));
			
		Tamanho t1 = Tamanho.builder()
				.id(UUID.fromString("d134a92e-889f-11e9-bc42-526af7764f64"))
				.centimetros(10).build();
		
		Sabor saborNovo = Sabor.builder().nome("Ousadinho").build();
		float precoDoTamanho = 15;
		saborNovo.getPrecos().add(new SaborPrecoTamanho(tamanho, saborNovo, precoDoTamanho ));
		
		int quantidadePrecosTamanhoAntes = saborNovo.getPrecos().size();
		
		Sabor saborInserido = service.cadastrar(saborNovo);
		
		int quantidadePrecosTamanhoDepois = saborInserido.getPrecos().size();
		
		
		assertTrue(quantidadePrecosTamanhoDepois > quantidadePrecosTamanhoAntes );
		
		assertTrue(existeUmPrecoTamanhoNoValorDe(saborInserido, precoDoTamanho));
		
		assertTrue(saborInserido.getRecheios().isEmpty());
		
	}

	private boolean existeUmPrecoTamanhoNoValorDe(Sabor saborInserido, float preco) {
		return saborInserido.getPrecos().stream().anyMatch(precoTamanho -> precoTamanho.getPreco() == preco);
	}
	
	@Test
	@DisplayName("Buscar um sabor por ID")
	void bTest() {
		
		assertNotNull(service.buscarPorId( saborCadastrado.getId() ));
		
	}
	
	@Test
	@DisplayName("Editar um sabor alterando apenas seu nome, e os outros atributos sendo null")
	void yTest() {
		UUID uid = saborCadastrado.getId();
		String novoNome = "Apresuntado";
		
		Sabor saborEditado = new Sabor();
		saborEditado.setId(uid);
		saborEditado.setNome(novoNome);
		
		saborEditado.setRecheios(saborCadastrado.getRecheios());
		
		Sabor novoSaborEditado = service.editar(saborEditado);
		
		assertTrue(novoSaborEditado.getNome().equals(saborEditado.getNome()));
		assertNotNull(novoSaborEditado.getRecheios());
		
		saborCadastrado = novoSaborEditado;
		
	}
	
	
	@Test
	@DisplayName("Excluir um recheio do sabor")
	void wTest() {
		
		UUID UID = saborCadastrado.getId();
		
		Sabor saborEncontrado = service.buscarPorId(UID);
		
		assertNotNull( saborEncontrado );
		
		int quantidadeDeRecheioAntes = saborEncontrado.getRecheios().size();
		
		saborEncontrado.removerRecheioNaPosicao(1);
		
		
		saborEncontrado = service.editar(saborEncontrado);
		
		int quantidadeDeRecheioDepois = saborEncontrado.getRecheios().size();
		
		assertEquals(quantidadeDeRecheioAntes, (quantidadeDeRecheioDepois + 1) );
		
		saborCadastrado = saborEncontrado;
		
	}
	
	@Test
	@DisplayName("Excluir sabor por seu ID")
	void zTest() {
		
		UUID UID = saborCadastrado.getId();
		
		assertNotNull( service.buscarPorId(UID) );
		
		service.deletar(UID);
		
		assertThrows(EntityNotFoundException.class, () -> service.buscarPorId(UID));
		
	}
	
	private void criarSetDeRecheios(Sabor saborNovo, Recheio... args) {
		
		int posicao = 1;
		for (Recheio recheio : args) {
			saborNovo.adicionarRecheio(recheio, posicao++);
		}
		
	}
	
	private void criarSetDeRecheios(Set<SaborOrdemRecheio> recheios, Recheio... args) {
		
		int posicao = 1;
		for (Recheio recheio : args) {
			recheios.add( 
					new SaborOrdemRecheio( recheio, posicao++ ));
		}
		
	}
}
