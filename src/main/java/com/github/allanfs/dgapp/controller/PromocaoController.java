package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Promocao;
import com.github.allanfs.dgapp.service.PromocaoService;

@RestController
public class PromocaoController implements IController<Promocao> {

	private static final String SERVICO = "/promocao";
	
	@Autowired
	private PromocaoService promocaoServ;
	
	@Override
	@PostMapping(SERVICO)
	public Promocao cadastrar(Promocao obj) {
		return promocaoServ.cadastrar(obj);
	}

	@Override
	@GetMapping(SERVICO)
	public List<Promocao> buscarTodos() {
		return promocaoServ.buscarTodos();
	}

	@Override
	@GetMapping(SERVICO + "/{id}")
	public Promocao buscarPorId(Long id) {
		return promocaoServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Promocao editar(Promocao obj, Long id) {
		return promocaoServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		promocaoServ.deletar(id);
	}

}
