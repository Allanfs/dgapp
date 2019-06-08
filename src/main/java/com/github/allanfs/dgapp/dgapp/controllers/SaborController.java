package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.ArrayList;
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

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.service.SaborService;

@RestController
@RequestMapping(name = "SaborController", path="/sabor")
public class SaborController implements Controller<Sabor>{

	@Autowired
	private SaborService service;
	
	@Override
	@PostMapping
	public ResponseEntity<Sabor> cadastrar(Sabor obj) {
		service.cadastrar(obj);
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Sabor>> buscarTodos() {
		ArrayList<Sabor> todos = (ArrayList<Sabor>)service.buscarTodos();
		return new ResponseEntity<List<Sabor>>( todos, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Sabor> buscarPorId(UUID id) {
		Sabor retorno = service.buscarPorId(id);
		return ResponseEntity.ok(retorno);
	}
	
	@Override
	@GetMapping("/buscar")
	public ResponseEntity<Sabor> buscarPorNome(String nome) {
		Sabor retorno = service.buscarPorNome(nome);
		return ResponseEntity.ok(retorno);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Sabor> editar(Sabor obj, UUID id) {
		// TODO obj é o sabor editado
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(UUID id) {
		service.deletar(id);
	}

}
