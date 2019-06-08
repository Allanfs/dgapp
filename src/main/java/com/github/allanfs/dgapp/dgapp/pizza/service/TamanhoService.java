package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.repository.TamanhoRepository;

@Service
public class TamanhoService implements IService<Tamanho>{

    @Autowired
    private TamanhoRepository tamanhoRepo;
    
    @Autowired
    private MessageSource mensagem;

    public Tamanho cadastrar(Tamanho tamanho){
        return tamanhoRepo.save(tamanho);
    }
    
    public Tamanho editar(Tamanho tamanhoEditar){
    	
    	if( tamanhoEditar.getId() == null ) {
    		throw new EntityNotFoundException(mensagem.getMessage("tamanho.nao.cadastrado", null, Locale.ROOT));
    	}
    	
    	Optional<Tamanho> tamanhoBuscadoOpt = tamanhoRepo.findById( tamanhoEditar.getId() );
    	
    	if(tamanhoBuscadoOpt.isPresent()) {
    		
    		return tamanhoRepo.save(tamanhoEditar);
    		
    	}else {
    		throw new EntityNotFoundException(mensagem.getMessage("tamanho.nao.cadastrado", null, Locale.ROOT));
    	}
    	
    }

    public List<Tamanho> buscarTodos(){
        return tamanhoRepo.findAll();
    }

    public Tamanho buscarPorId( UUID id) {
        Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findById( id );
        
        if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException(mensagem.getMessage("tamanho.inexistente", null, Locale.ROOT));
        }
        
		return tamanhoBuscado.get();
    }
    
    @Override
	public Tamanho buscarPorNome(String nome) {
    	Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findByNome( nome );
    	
        if( !tamanhoBuscado.isPresent() ) {
			throw new EntityNotFoundException(
					mensagem.getMessage("tamanho.x.inexistente", new Object[] { nome }, Locale.ROOT));
        }
        
		return tamanhoBuscado.get();
	}
    
    public void deletar( UUID id ) {
    	
    	Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findById( id );
    	
    	if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException(mensagem.getMessage("tamanho.inexistente", null, Locale.ROOT));
        }
    	
    	tamanhoRepo.delete( tamanhoBuscado.get() );
    }

	
    
}