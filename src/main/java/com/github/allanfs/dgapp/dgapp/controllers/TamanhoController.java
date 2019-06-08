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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.service.TamanhoService;

@RestController
@RequestMapping(name = "TamanhoController", path="/tamanho")
public class TamanhoController implements Controller<Tamanho>{

	@Autowired
	private TamanhoService service;
	
	@Override
	@PostMapping
	public ResponseEntity<Tamanho> cadastrar(Tamanho obj) {
		Tamanho novoTamanho = service.cadastrar(obj);
		return new ResponseEntity<Tamanho>( novoTamanho, HttpStatus.OK);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<Tamanho>> buscarTodos() {
		ArrayList<Tamanho> todos = (ArrayList<Tamanho>) service.buscarTodos();
		return new ResponseEntity<List<Tamanho>>( todos , HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Tamanho> buscarPorId(UUID id) {
		Tamanho retorno = service.buscarPorId(id);
		return ResponseEntity.ok(retorno);
	}

	@Override
	@GetMapping("/buscar")
	public ResponseEntity<Tamanho> buscarPorNome(String nome) {
		Tamanho retorno = service.buscarPorNome(nome);
		return ResponseEntity.ok(retorno);
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Tamanho> editar(Tamanho obj, UUID id) {
		
		
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(UUID id) {
		service.deletar(id);
	}


}
