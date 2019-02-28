package com.github.allanfs.dgapp.controller;

import java.util.List;

import com.github.allanfs.dgapp.modelo.Endereco;
import com.github.allanfs.dgapp.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController implements IController<Endereco> {

	private static final String SERVICO = "/endereco";
	
	@Autowired
	private EnderecoService enderecoServ;
	
	@Override
	@PostMapping(SERVICO)
	public Endereco cadastrar(Endereco obj) {
		return enderecoServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Endereco> buscarTodos() {
		return enderecoServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Endereco buscarPorId(Long id) {
		return enderecoServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Endereco editar(Endereco obj, Long id) {
		return enderecoServ.cadastrar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		enderecoServ.deletar( id );
	}

}
