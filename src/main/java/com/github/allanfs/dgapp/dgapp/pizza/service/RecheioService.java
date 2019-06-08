package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.repository.RecheioRepository;

@Service
public class RecheioService implements IService<Recheio>{

    @Autowired
    private RecheioRepository recheioRepo;

    @Autowired
    private MessageSource mensagem;
    
    public Recheio cadastrar(Recheio Recheio){
        return recheioRepo.save(Recheio);
    }
    
    public Recheio editar(Recheio recheio){
    	
    	// 1) id do recheio é igual a nulo?
    	// 2) o retorno da busca pelo recheio é igual a nulo?
    	if( recheio.getId() == null | buscarPorId( recheio.getId() ) == null ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
        return recheioRepo.save(recheio);
    }

    public List<Recheio> buscarTodos(){
        return recheioRepo.findAll();
    }

    public Recheio buscarPorId( UUID id) {
    	Optional<Recheio> recheioBuscado = recheioRepo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
        return recheioBuscado.get();
    }
    
    public Recheio buscarPorNome( String nome ) {
    	Optional<Recheio> recheioBuscado = recheioRepo.findByNome( nome );
    	
    	if( !recheioBuscado.isPresent() ) {
			throw new EntityNotFoundException(
					mensagem.getMessage("recheio.x.inexistente", new Object[] { nome }, Locale.ROOT));
    	}
    	
        return recheioBuscado.get();
    }
    
    public void deletar( UUID id ) {
    	
    	Optional<Recheio> recheioBuscado = recheioRepo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
    	recheioRepo.delete( recheioBuscado.get() );
    }
    
}