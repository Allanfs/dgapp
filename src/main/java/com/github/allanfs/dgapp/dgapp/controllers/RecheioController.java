package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.service.RecheioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST recheio")
@RestController
@RequestMapping(name = "RecheioController",path = "/recheio")
public class RecheioController implements Controller<Recheio>{

	@Autowired
	private RecheioService service;
	
	@Override
	@PostMapping
	@ApiOperation(value="Cadastra um recheio, e retorna o dado cadastrado")
	public ResponseEntity<Recheio> cadastrar(Recheio obj) {
		Recheio novoRecheio = service.cadastrar(obj);
		return new ResponseEntity<Recheio>( novoRecheio, HttpStatus.OK);
	}

	@Override
	@GetMapping()
	@ApiOperation(value="Busca todos os recheios cadastrados")
	public ResponseEntity<List<Recheio>> buscarTodos() {
		service.buscarTodos();
		return null;
	}

	@Override
	@GetMapping("/{id}")
	@ApiOperation(value="Busca um recheio pelo seu ID")
	public ResponseEntity<Recheio> buscarPorId(UUID id) {
		Recheio retorno = service.buscarPorId(id);
		return ResponseEntity.ok(retorno);
	}

	@Override
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um recheio pelo seu ID")
	public ResponseEntity<Recheio> editar(Recheio obj, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	@ApiOperation(value="Exclui um recheio pelo seu ID")
	public void deletar(UUID id) {
		
		service.deletar(id);
		
	}

}
