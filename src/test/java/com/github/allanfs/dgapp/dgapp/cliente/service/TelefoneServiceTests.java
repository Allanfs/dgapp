package com.github.allanfs.dgapp.dgapp.cliente.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TelefoneServiceTests {

	@Autowired
	private TelefoneService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	@DisplayName("Cadastrar telefone, indicando o cliente que o posui")
	public void cadastrarBem() {
		
		UUID id = UUID.fromString("b0e833f0-8d06-11e9-bc42-526af7764f64");
		
		Cliente cliente = Cliente.builder().id(id).nome("Fulano").build();
		
		Telefone telefone = Telefone.builder().ddd(3214).numero("987654321").whatsapp(true).observacao("sempre está sem credito...").cliente(cliente).build();
		
		assertDoesNotThrow(() -> service.cadastrar(telefone) );
		
	}
	
	@Test
	@DisplayName("Cadastrar telefone, sem indicar o cliente que o possui")
	public void cadastrarSemInformarCliente() {
		
		Telefone telefone = Telefone.builder().ddd(83).numero("321654987").whatsapp(false).observacao("Tim").build();
		
		assertThrows( EntityNotFoundException.class, () -> service.cadastrar(telefone), "Um cliente foi informado" );
		
	}
	
	@Test
	@DisplayName("Editar os dados de um telefone")
	void cTest() {
		
		int ddd = 90;
		String numero = "654987321";
		
		UUID idTelefone = UUID.fromString("62c48160-8d0b-11e9-bc42-526af7764f64");
		UUID idCliente = UUID.fromString("b0e837d8-8d06-11e9-bc42-526af7764f64");
		
		Telefone telefone = Telefone.builder()
				.id(idTelefone)
				.ddd(83)
				.numero("990690637")
				.whatsapp(false)
				.cliente( Cliente.builder().id(idCliente).build() )
				.build();
		
		Telefone telefoneEditar = Telefone.builder().id(idTelefone).ddd(ddd).numero(numero).cliente(Cliente.builder().id(idCliente).build()).build();
		
		service.editar(telefoneEditar);
		
		assertNotEquals(telefone, telefoneEditar);
		
		assertEquals(ddd, telefoneEditar.getDdd());
		assertEquals(numero, telefoneEditar.getNumero());
		
	}
	
	@Test
	@DisplayName("Buscar um telefone pesquisando pelo cliente que o possui")
	void dTest() {
		
	}
	
	@Test
	@DisplayName("Buscar um telefone pelo seu número")
	void eTest() {
		
	}
	
	@ParameterizedTest
	@DisplayName("Excluir um telefone informando seu id")
	@ValueSource(strings = {"62c479c2-8d0b-11e9-bc42-526af7764f64", "62c48160-8d0b-11e9-bc42-526af7764f64"})
	void fTest( String id ) {
		
		UUID uid = UUID.fromString(id);
		
		assertDoesNotThrow(() -> service.deletar(uid) );
	}
	
	@ParameterizedTest
	@DisplayName("Excluir um telefone informando seu id que não existe")
	@ValueSource(strings = {"62c479c2-010b-11e9-bc42-526af7764f64", "62c48160-8d0b-11e9-010b-526af7764f64"})
	void excluirTelefoneInexistenteTest( String id ) {
		
		UUID uid = UUID.fromString(id);
		
		assertThrows( EntityNotFoundException.class, () -> service.deletar(uid) );
		
	}
	
	@Test
	@DisplayName("Excluir um telefone informando seu número")
	void gTest() {
		
	}
	
}
