package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Categoria;
import com.github.allanfs.dgapp.service.CategoriaService;

@RestController
public class CategoriaController implements IController<Categoria> {

	private static final String SERVICO = "/categoria";
	
	@Autowired
	private CategoriaService categoriaServ;
	
	@PostMapping(SERVICO)
	public Categoria cadastrar(Categoria categoria) {
		return categoriaServ.cadastrar(categoria);
	}
	
	@GetMapping(value=SERVICO, produces="application/json")
	public List<Categoria> buscarTodos(){
		return categoriaServ.buscarTodos();
	}
	
	@GetMapping(value=SERVICO + "/{id}", produces="application/json")
	public Categoria buscarPorId( Long id) {
		return categoriaServ.buscarPorId(id);
	}
	
	@PutMapping(SERVICO + "/{id}")
	public Categoria editar( Categoria categoria, Long id) {
		return categoriaServ.cadastrar(categoria);
	}
	
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar( Long id ) {
		categoriaServ.deletar( id );
	}
	
}
