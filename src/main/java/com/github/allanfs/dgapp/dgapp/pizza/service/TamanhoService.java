package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.repository.TamanhoRepository;

/**
 * Os métodos se reponsabilizam de verificar
 * a consistencia dos dados, e caso não estejam
 * corretos, devem lançar exceções, as quais devem
 * ser tratadas pelos controllers.
 * @author allan
 *
 */
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
    
    public void deletar( UUID id ) {
    	
    	Optional<Tamanho> tamanhoBuscado = tamanhoRepo.findById( id );
    	
    	if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException("Tamanho Inexistente");
        }
    	
    	tamanhoRepo.delete( tamanhoBuscado.get() );
    }
    
}