package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.repository.EnderecoRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

@Service
public class EnderecoService implements IService<Endereco> {

	@Autowired
	private EnderecoRepository repo;
	
	@Override
	public Endereco cadastrar(Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco editar(Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
