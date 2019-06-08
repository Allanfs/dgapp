package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.repository.RecheioRepository;

@Service
public class RecheioService implements IService<Recheio>{

    @Autowired
    private RecheioRepository recheioRepo;

    public Recheio cadastrar(Recheio Recheio){
        return recheioRepo.save(Recheio);
    }
    
    public Recheio editar(Recheio Recheio){
        return recheioRepo.save(Recheio);
    }

    public List<Recheio> buscarTodos(){
        return recheioRepo.findAll();
    }

    public Recheio buscarPorId( UUID id) {
    	Optional<Recheio> recheioBuscado = recheioRepo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException("Recheio Inexistente");
    	}
    	
        return recheioBuscado.get();
    }
    
    public Recheio buscarPorNome( String nome ) {
    	Optional<Recheio> recheioBuscado = recheioRepo.findByNome( nome );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException( String.format("Recheio %s inexistente", nome ) );
    	}
    	
        return recheioBuscado.get();
    }
    
    public void deletar( UUID id ) {
    	
    	Optional<Recheio> recheioBuscado = recheioRepo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException("Recheio Inexistente");
    	}
    	
    	recheioRepo.delete( recheioBuscado.get() );
    }
    
}