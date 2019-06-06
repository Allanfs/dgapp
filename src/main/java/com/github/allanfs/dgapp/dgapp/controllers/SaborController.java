package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

@RestController
@RequestMapping(name = "SaborController", path="/sabor")
public class SaborController implements Controller<Sabor>{

	
	@Override
	@PostMapping
	public ResponseEntity<Sabor> cadastrar(Sabor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<Sabor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Sabor> buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Sabor> editar(Sabor obj, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
