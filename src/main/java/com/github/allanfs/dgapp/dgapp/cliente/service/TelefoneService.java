package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;
import com.github.allanfs.dgapp.dgapp.cliente.repository.TelefoneRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

public class TelefoneService implements IService<Telefone> {

	@Autowired
	private TelefoneRepository repo;
	
	@Override
	public Telefone cadastrar(Telefone obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone editar(Telefone obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefone> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
