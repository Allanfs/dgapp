package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {

	public T cadastrar( @RequestBody T obj );
	public List<T> buscarTodos();
	public T buscarPorId(@PathVariable Long id );
	public T editar( @RequestBody  T obj, @PathVariable Long id);
	public void deletar( @PathVariable Long id );
	
}