package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;
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
		
		if (obj.getTelefone() != null) {

			inserirClienteNoTelefoneCasoNaoTenha(obj);
		}
		
		if (obj.getEndereco() != null) {

			inserirClienteNoEnderecoCasoNaoTenha(obj);
		}
		
		return repo.save(obj);
	}

	private void inserirClienteNoEnderecoCasoNaoTenha(Cliente obj) {
		if (!obj.getEndereco().isEmpty()) {
			Consumer<? super Endereco> setClienteSeForNull = endereco -> {
				if (endereco.getCliente() == null)
					endereco.setCliente(obj);
			};
			obj.getEndereco().forEach(setClienteSeForNull);
		}
	}

	private void inserirClienteNoTelefoneCasoNaoTenha(Cliente obj) {
		if (!obj.getTelefone().isEmpty()) {
			Consumer<? super Telefone> setClienteSeForNull = telefone -> {
				if (telefone.getCliente() == null)
					telefone.setCliente(obj);
			};
			obj.getTelefone().forEach(setClienteSeForNull);
		}
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
