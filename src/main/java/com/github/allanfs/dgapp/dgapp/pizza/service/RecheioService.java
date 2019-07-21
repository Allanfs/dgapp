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
    private RecheioRepository repo;

    @Autowired
    private MessageSource mensagem;
    
    public Recheio cadastrar(Recheio Recheio){
        return repo.save(Recheio);
    }
    
    public Recheio editar(Recheio recheio){
    	
    	if( recheio.getId() == null | repo.existsById(recheio.getId()) ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
        return repo.save(recheio);
    }

    public List<Recheio> buscarTodos(){
        return repo.findAll();
    }

    public Recheio buscarPorId( UUID id) {
    	Optional<Recheio> recheioBuscado = repo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
        return recheioBuscado.get();
    }
    
    public Recheio buscarPorNome( String nome ) {
    	Optional<Recheio> recheioBuscado = repo.findByNome( nome );
    	
    	if( !recheioBuscado.isPresent() ) {
			throw new EntityNotFoundException(
					mensagem.getMessage("recheio.x.inexistente", new Object[] { nome }, Locale.ROOT));
    	}
    	
        return recheioBuscado.get();
    }
    
    public void deletar( UUID id ) {
    	
    	Optional<Recheio> recheioBuscado = repo.findById( id );
    	
    	if( !recheioBuscado.isPresent() ) {
    		throw new EntityNotFoundException(mensagem.getMessage("recheio.inexistente", null, Locale.ROOT));
    	}
    	
    	repo.delete( recheioBuscado.get() );
    }

	@Override
	public Integer obterQuantidadeDeRegistrosAtivos() {
		return repo.contarQuantidadeDeRecheios();
	}
    
}