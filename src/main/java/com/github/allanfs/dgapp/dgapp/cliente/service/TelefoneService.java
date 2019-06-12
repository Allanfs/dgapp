package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;
import com.github.allanfs.dgapp.dgapp.cliente.repository.TelefoneRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

public class TelefoneService implements IService<Telefone> {

	@Autowired
	private TelefoneRepository repo;
	
    @Autowired
    private MessageSource mensagem;
	
	@Override
	public Telefone cadastrar(Telefone obj) {
		repo.save(obj);
		return null;
	}

	@Override
	public Telefone editar(Telefone obj) {
		
    	if( obj.getId() == null | repo.existsById(obj.getId()) ) {
    		throw new EntityNotFoundException(mensagem.getMessage("telefone.inexistente", null, Locale.ROOT));
    	}
    	
		return repo.save(obj);
	}

	@Override
	public List<Telefone> buscarTodos() {
		return repo.findAll();
	}
	
	/**
	 * TODO o que acontece se passa um cliente não null que não tenha id?
	 * @param cliente
	 * @return lista de telefones do cliente; ou lista vazia caso <i>cliente ou seu id</i> sejam null
	 */
	public List<Telefone> buscarTodosDeUmCliente( Cliente cliente ) {
		if(cliente != null) {
			
			return repo.findByCliente( cliente.getId() );
			
		}else {
			
			return new ArrayList<Telefone>();
			
		}
	}

	@Override
	public Telefone buscarPorId(UUID id) {
		
		if(repo.existsById(id)) {
			return repo.findById(id).get();
		}else {
			throw new EntityNotFoundException(mensagem.getMessage("telefone.inexistente", null, Locale.ROOT));
		}
		
	}

	@Override
	public Telefone buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
	}

}
