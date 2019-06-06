package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

@RestController
@RequestMapping(name = "TamanhoController", path="/tamanho")
public class TamanhoController implements Controller<Tamanho>{

	@Override
	@PostMapping
	public ResponseEntity<Tamanho> cadastrar(Tamanho obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<Tamanho> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Tamanho> buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Tamanho> editar(Tamanho obj, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
