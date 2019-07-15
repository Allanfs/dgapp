package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.repository.EnderecoRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

@Service
public class EnderecoService implements IService<Endereco> {

	@Autowired
	private EnderecoRepository repo;
	
	@Autowired
    private MessageSource mensagem;
	
	@Override
	public Endereco cadastrar(Endereco obj) {
		
		if(obj.getCliente() == null) {
			throw new EntityNotFoundException(mensagem.getMessage("cliente.inexistente", null, Locale.ROOT));
		}else {
			return repo.save(obj);
		}
	}

	@Override
	public Endereco editar(Endereco obj) {
		if(obj.getId() == null) {
			
			throw new EntityNotFoundException(mensagem.getMessage("endereco.invalido", null, Locale.ROOT));
			
		}else {
			
			if(obj.getCliente() == null) {
				
				throw new EntityNotFoundException(mensagem.getMessage("cliente.inexistente", null, Locale.ROOT));
				
			}else {
				
				return repo.save(obj);
				
			}
		}
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
		// NÃO IMPLEMENTADO
		return null;
	}

	@Override
	public void deletar(UUID id) {
		
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}else {
			throw new EntityNotFoundException(mensagem.getMessage("endereco.inexistente", null, Locale.ROOT));
		}
		
	}

	@Override
	public Integer obterQuantidadeDeRegistrosAtivos() {
		return repo.contarQuantidadeDeEnderecosCadastrados();
	}

}
