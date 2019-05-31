package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.pizza.Recheio;
import com.github.allanfs.dgapp.service.RecheioService;

@RestController
public class RecheioController implements IController<Recheio> {

	private static final String SERVICO = "/recheio";
	
	@Autowired
	private RecheioService recheioServ;
	
	@Override
	@PostMapping(SERVICO)
	public Recheio cadastrar(Recheio obj) {
		return recheioServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Recheio> buscarTodos() {
		return recheioServ.buscarTodos();
	}
	
	@Override
	@GetMapping(SERVICO + "/{id}")
	public Recheio buscarPorId(Long id) {
		return recheioServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Recheio editar(Recheio obj, Long id) {
		return recheioServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		recheioServ.deletar(id);
	}

}
