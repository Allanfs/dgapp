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
    private RecheioService recheioService;
    
    @Autowired
    private MessageSource mensagem;

    public Sabor cadastrar(Sabor sabor){
    	
    	sabor.getRecheios().forEach( saborOrdemRecheio -> {
    		
    		if( saborOrdemRecheio.getId() == null ) {
    			// lançar exceção: não existe recheio associado
    			// entityNotFound: não existe recheio associado para o sabor
    		}else {
    			// verificar se o recheio existe - se lançar exceção então não existe
    			saborOrdemRecheio.setRecheio( recheioService.buscarPorId( saborOrdemRecheio.getRecheio().getId() ) );
    			
    			// verificar se a posição é maior que 0
    			if( saborOrdemRecheio.getPosicao() < 0 ) {
    				// lança exceção posição negativa
    				// posição negativa: um recheio não pode ter uma posição menor que zero
    			}
    			
    			// settar o sabor
    			saborOrdemRecheio.setSabor(sabor);
    		}
    		
    	});
    	
        return saborRepo.save(sabor);
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