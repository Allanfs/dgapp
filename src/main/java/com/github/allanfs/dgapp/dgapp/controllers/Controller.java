package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

interface Controller<T> {

	ResponseEntity<T> cadastrar( @RequestBody T obj );
	
	ResponseEntity<List<T>> buscarTodos();
	
	ResponseEntity<T> buscarPorId(@PathVariable UUID id );
	
	ResponseEntity<T> editar( @RequestBody  T obj, @PathVariable UUID id);
	
	void deletar( @PathVariable UUID id );
}
