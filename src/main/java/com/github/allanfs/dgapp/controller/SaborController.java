package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Sabor;
import com.github.allanfs.dgapp.modelo.SaborPrecoEmbeddedId;
import com.github.allanfs.dgapp.service.SaborService;

@RestController
public class SaborController implements IController<Sabor>{

	private static final String SERVICO = "/sabor";
	
	@Autowired
	private SaborService saborServ;
	
	@Override
	@PostMapping(SERVICO)
	public Sabor cadastrar(Sabor obj) {
		
		obj.getPrecosTamanhos().forEach(pt -> pt.getId().setSabor(obj) );
		
		return saborServ.cadastrar(obj);
	}

	@Override
	@GetMapping(value=SERVICO)
	public List<Sabor> buscarTodos() {
		return saborServ.buscarTodos();
	}

	@Override
	@GetMapping(value=SERVICO + "/{id}")
	public Sabor buscarPorId(Long id) {
		return saborServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Sabor editar(Sabor obj, Long id) {
		System.out.println(obj.getNome());
//		obj.getPrecosTamanhos().forEach( pt -> System.out.println(pt) );
		Sabor editar = saborServ.editar(obj);
		
		
		return editar;
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		saborServ.deletar(id);
	}
	
}