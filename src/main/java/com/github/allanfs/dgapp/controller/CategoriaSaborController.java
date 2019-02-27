package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.CategoriaSabor;
import com.github.allanfs.dgapp.service.CategoriaSaborService;

@RestController
public class CategoriaSaborController implements IController<CategoriaSabor> {

	private static final String SERVICO = "/categoria";
	
	private CategoriaSaborService categoriaServ = new CategoriaSaborService();
	
	@PostMapping(SERVICO)
	public CategoriaSabor cadastrar(CategoriaSabor categoria) {
		return categoriaServ.cadastrar(categoria);
	}
	
	@GetMapping(SERVICO)
	public List<CategoriaSabor> buscarTodos(){
		return categoriaServ.buscarTodos();
	}
	
	@GetMapping(SERVICO + "/{id}")
	public CategoriaSabor buscarPorId( Long id) {
		return categoriaServ.buscarPorId(id);
	}
	
	@PutMapping(SERVICO + "/{id}")
	public CategoriaSabor editar( CategoriaSabor categoria, Long id) {
		return categoriaServ.cadastrar(categoria);
	}
	
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar( Long id ) {
		categoriaServ.deletar( id );
	}
	
}
