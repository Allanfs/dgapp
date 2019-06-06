package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;

@RestController
@RequestMapping(name = "RecheioController",path = "/recheio")
public class RecheioController implements Controller<Recheio>{

	
	@Override
	public ResponseEntity<Recheio> cadastrar(Recheio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<Recheio> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Recheio> buscarPorId(UUID id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

}
