package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.service.RecheioService;

@RestController
@RequestMapping(name = "RecheioController",path = "/recheio")
public class RecheioController implements Controller<Recheio>{

	@Autowired
	private RecheioService service;
	
	@Override
	public ResponseEntity<Recheio> cadastrar(Recheio obj) {
		service.cadastrar(obj);
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Recheio>> buscarTodos() {
		service.buscarTodos();
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Recheio> buscarPorId(UUID id) {
		service.buscarPorId(id);
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Recheio> editar(Recheio obj, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(UUID id) {
		service.deletar(id);
		
	}

}
