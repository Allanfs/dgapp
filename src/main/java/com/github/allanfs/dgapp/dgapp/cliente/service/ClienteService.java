package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.repository.ClienteRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

@Service
public class ClienteService implements IService<Cliente> {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
    private MessageSource mensagem;
	
	@Override
	public Cliente cadastrar(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente editar(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
