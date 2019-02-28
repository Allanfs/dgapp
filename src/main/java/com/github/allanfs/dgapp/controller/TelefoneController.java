package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Telefone;
import com.github.allanfs.dgapp.service.TelefoneService;

@RestController
public class TelefoneController implements IController<Telefone> {

	private static final String SERVICO = "/telefone";
	
	@Autowired
	private TelefoneService TelefoneServ;
	
	@Override
	@PostMapping(SERVICO)
	public Telefone cadastrar(Telefone obj) {
		return TelefoneServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Telefone> buscarTodos() {
		return TelefoneServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Telefone buscarPorId(Long id) {
		return TelefoneServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Telefone editar(Telefone obj, Long id) {
		return TelefoneServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		TelefoneServ.deletar(id);
	}

}
