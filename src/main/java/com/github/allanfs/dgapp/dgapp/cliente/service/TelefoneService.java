package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;
import com.github.allanfs.dgapp.dgapp.cliente.repository.TelefoneRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

@Service
public class TelefoneService implements IService<Telefone> {

	@Autowired
	private TelefoneRepository repo;
	
    @Autowired
    private MessageSource mensagem;
	
	@Override
	public Telefone cadastrar(Telefone obj) {
		
		if( obj.getCliente() == null ) {
			throw new EntityNotFoundException(mensagem.getMessage("cliente.inexistente", null, Locale.ROOT));
		}
		
		repo.save(obj);
		return null;
	}

	@Override
	public Telefone editar(Telefone obj) {
		
//    	if( obj.getId() == null | repo.existsById(obj.getId()) ) {
//    		throw new EntityNotFoundException(mensagem.getMessage("telefone.inexistente", null, Locale.ROOT));
//    	}
    	
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
	
	public Telefone buscarPorTelefone( String numero ) {
		Optional<Telefone> telefoneOpt = repo.findByNumero(numero);
		if (telefoneOpt.isPresent()) {
			return telefoneOpt.get();
		}else {
			throw new EntityNotFoundException(mensagem.getMessage("telefone.x.nao.encontrado", new Object[] {numero} , Locale.ROOT));
		}
	}
	
	public boolean deletar(Telefone telefone) {
		if(repo.existsById( telefone.getId() )) {
			repo.delete(telefone);
			return true;
		}
		return false;
	}

	@Override
	public void deletar(UUID id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}else {
			throw new EntityNotFoundException(mensagem.getMessage("telefone.inexistente", null, Locale.ROOT));
		}
	}
	
	public void deletarPorNumero( String numero ) {
		
		repo.deleteByNumero( buscarPorTelefone(numero).getNumero() );
	}

}
