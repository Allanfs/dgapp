package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Tamanho;
import com.github.allanfs.dgapp.service.TamanhoService;

@RestController
public class TamanhoController implements IController<Tamanho> {

	private static final String SERVICO = "/tamanho";
	
	@Autowired
	private TamanhoService tamanhoServ;
	
	@Override
	@PostMapping(SERVICO)
	public Tamanho cadastrar(Tamanho obj) {
		return tamanhoServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Tamanho> buscarTodos() {
		return tamanhoServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Tamanho buscarPorId(Long id) {
		return tamanhoServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Tamanho editar(Tamanho obj, Long id) {
		return tamanhoServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		tamanhoServ.deletar(id);
	}

}
