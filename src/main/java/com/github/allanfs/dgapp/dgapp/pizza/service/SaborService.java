package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.repository.SaborRepository;

@Service
public class SaborService implements IService<Sabor>{

    @Autowired
    private SaborRepository saborRepo;
    
    @Autowired
    private MessageSource mensagem;

    public Sabor cadastrar(Sabor Sabor){
        return saborRepo.save(Sabor);
    }
    
    public Sabor editar(Sabor Sabor){
        return saborRepo.save(Sabor);
    }

    public List<Sabor> buscarTodos(){
        return saborRepo.findAll();
    }

    public Sabor buscarPorId( UUID id) {
    	Optional<Sabor> saborBuscado = saborRepo.findById( id );
    	
    	if( !saborBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("sabor.inexistente", null, Locale.ROOT));
    	}
        return saborBuscado.get();
    }
    
    public Sabor buscarPorNome( String nome) {
    	Optional<Sabor> saborBuscado = saborRepo.findByNome( nome );
    	
    	if( !saborBuscado.isPresent() ) {
			throw new EntityNotFoundException(
					mensagem.getMessage("sabor.x.inexistente", new Object[] { nome }, Locale.ROOT));
    	}
        return saborBuscado.get();
    }
    
    public void deletar( UUID id ) {
    	
    	Optional<Sabor> saborBuscado = saborRepo.findById( id );
    	
    	if( !saborBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("sabor.inexistente", null, Locale.ROOT));
    	}
    	
    	saborRepo.delete(saborBuscado.get());
    }
    
}