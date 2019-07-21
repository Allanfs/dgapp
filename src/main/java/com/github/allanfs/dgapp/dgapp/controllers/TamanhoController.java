package com.github.allanfs.dgapp.dgapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.service.TamanhoService;

@RestController
@RequestMapping(name = "TamanhoController", path="/tamanhos")
public class TamanhoController extends AbstractController<Tamanho>{

	@Autowired
	private TamanhoService service;
	
	@GetMapping("/buscar")
	public ResponseEntity<Tamanho> buscarPorNome(String nome) {
		Tamanho retorno = service.buscarPorNome(nome);
		return ResponseEntity.ok(retorno);
	}

}
