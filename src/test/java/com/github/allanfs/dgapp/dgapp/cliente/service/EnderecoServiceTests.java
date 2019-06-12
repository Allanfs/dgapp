package com.github.allanfs.dgapp.dgapp.cliente.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EnderecoServiceTests {

	@Autowired
	private EnderecoService service;
	
	@Test
	@DisplayName("Cadastrar um endereço, indicando o cliente que o possui")
	void atest() {
		String idCliente = "b0e837d8-8d06-11e9-bc42-526af7764f64";
		UUID uidCliente = UUID.fromString(idCliente);
		
		Endereco endereco = Endereco.builder()
				.rua("Rua dos lobos")
				.numero("47")
				.bairro("BC")
				.cliente( Cliente.builder().id(uidCliente).build() )
				.build();
		
		assertDoesNotThrow(() -> service.cadastrar(endereco) );
		
	}

	@Test
	@DisplayName("Cadastrar um endereço, sem informar o cliente que o possui")
	void btest() {
		Endereco endereco = Endereco.builder().rua("Rua dos lobos").numero("47").bairro("BC").build();
		
		assertThrows(EntityNotFoundException.class, () -> service.cadastrar(endereco) );
		
	}
	
	@Test
	@DisplayName("Editar um endereço")
	void ctest() {
		String id = "0916dbac-8d2b-11e9-bc42-526af7764f64";
		String idCliente = "b0e837d8-8d06-11e9-bc42-526af7764f64";
		UUID uid = UUID.fromString(id);
		UUID uidCliente = UUID.fromString(idCliente);
		
		Endereco endEditar = Endereco.builder()
				.id(uid)
				.rua("Rua dos lobos numero zero")
				.numero("123")
				.bairro("BC")
				.cliente(Cliente.builder().id(uidCliente).build() )
				.build();
		
		assertDoesNotThrow( () -> service.editar(endEditar) );
		
	}
	
	@Test
	@DisplayName("Excluir em endereço")
	void test() {
		String id = "0916cc7a-8d2b-11e9-bc42-526af7764f64";
		UUID uid = UUID.fromString(id);
		
		assertDoesNotThrow( () -> service.deletar(uid) );
	}
	
}
