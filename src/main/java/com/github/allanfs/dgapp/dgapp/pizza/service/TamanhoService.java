package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.repository.TamanhoRepository;

@Service
public class TamanhoService implements IService<Tamanho>{

    @Autowired
    private TamanhoRepository tamanhoRepo;

    public Tamanho cadastrar(Tamanho tamanho){
        return tamanhoRepo.save(tamanho);
    }
    
    public Tamanho editar(Tamanho tamanho){
        return tamanhoRepo.save(tamanho);
    }

    public List<Tamanho> buscarTodos(){
        return tamanhoRepo.findAll();
    }

    public Tamanho buscarPorId( UUID id) {
        Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findById( id );
        
        if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException("Tamanho Inexistente");
        }
        
		return tamanhoBuscado.get();
    }
    
    @Override
	public Tamanho buscarPorNome(String nome) {
    	Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findByNome( nome );
        
        if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException( String.format("Tamanho %s inexistente", nome ) );
        }
        
		return tamanhoBuscado.get();
	}
    
    public void deletar( UUID id ) {
    	
    	Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findById( id );
    	
    	if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException("Tamanho Inexistente");
        }
    	
    	tamanhoRepo.delete( tamanhoBuscado.get() );
    }

	
    
}