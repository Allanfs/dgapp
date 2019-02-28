package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Produto;
import com.github.allanfs.dgapp.service.ProdutoService;

@RestController
public class ProdutoController implements IController<Produto> {

	private static final String SERVICO = "/Produto";
	
	@Autowired
	private ProdutoService ProdutoServ;
	
	@Override
	@PostMapping(SERVICO)
	public Produto cadastrar(Produto obj) {
		return ProdutoServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Produto> buscarTodos() {
		return ProdutoServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Produto buscarPorId(Long id) {
		return ProdutoServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Produto editar(Produto obj, Long id) {
		return ProdutoServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		ProdutoServ.deletar(id);
	}

}
