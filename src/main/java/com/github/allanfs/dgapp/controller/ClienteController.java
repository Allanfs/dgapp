package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Cliente;
import com.github.allanfs.dgapp.service.ClienteService;

@RestController
public class ClienteController implements IController<Cliente> {

	private static final String SERVICO = "/Cliente";
	
	@Autowired
	private ClienteService ClienteServ;
	
	@Override
	@PostMapping(SERVICO)
	public Cliente cadastrar(Cliente obj) {
		return ClienteServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Cliente> buscarTodos() {
		return ClienteServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Cliente buscarPorId(Long id) {
		return ClienteServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Cliente editar(Cliente obj, Long id) {
		return ClienteServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		ClienteServ.deletar(id);
	}

}
