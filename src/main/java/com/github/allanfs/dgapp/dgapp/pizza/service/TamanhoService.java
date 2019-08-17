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
    private TamanhoRepository repo;
    
    @Autowired
    private MessageSource mensagem;

    public Tamanho cadastrar(Tamanho tamanho){
    	if (tamanho.getNome() == null ||
    			tamanho.getNumeroFatias() == 0 ||
    			tamanho.getNumeroMaximoSabores() == 0||
    			tamanho.getPrecoPadrao() == 0 ||
    			tamanho.getCentimetros() == 0 ) {
			throw new IllegalArgumentException("Tamanho informado não possui todos os campos preenchidos");
		}
    	IService.logger.info("Cadastrando tamanho: nome [%s]", tamanho.getNome());
        return repo.save(tamanho);
    }
    
    public Tamanho editar(Tamanho tamanhoEditar){
    	
    	if( tamanhoEditar.getId() == null ) {
    		throw new EntityNotFoundException(mensagem.getMessage("tamanho.nao.cadastrado", null, Locale.ROOT));
    	}
    	
    	Optional<Tamanho> tamanhoBuscadoOpt = repo.findById( tamanhoEditar.getId() );
    	
    	if(tamanhoBuscadoOpt.isPresent()) {
    		
    		return repo.save(tamanhoEditar);
    		
    	}else {
    		throw new EntityNotFoundException(mensagem.getMessage("tamanho.nao.cadastrado", null, Locale.ROOT));
    	}
    	
    }

    public List<Tamanho> buscarTodos(){
        return repo.findAll();
    }

    public Tamanho buscarPorId( UUID id) {
        Optional<Tamanho> tamanhoBuscado = repo.findById( id );
        
        if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException(mensagem.getMessage("tamanho.inexistente", null, Locale.ROOT));
        }
        
		return tamanhoBuscado.get();
    }
    
    @Override
	public Tamanho buscarPorNome(String nome) {
    	Optional<Tamanho> tamanhoBuscado = repo.findByNome( nome );
    	
        if( !tamanhoBuscado.isPresent() ) {
			throw new EntityNotFoundException(
					mensagem.getMessage("tamanho.x.inexistente", new Object[] { nome }, Locale.ROOT));
        }
        
		return tamanhoBuscado.get();
	}
    
    public void deletar( UUID id ) {
    	
    	Optional<Tamanho> tamanhoBuscado = repo.findById( id );
    	
    	if( !tamanhoBuscado.isPresent() ) {
        	throw new EntityNotFoundException(mensagem.getMessage("tamanho.inexistente", null, Locale.ROOT));
        }
    	
    	repo.delete( tamanhoBuscado.get() );
    }

	@Override
	public Integer obterQuantidadeDeRegistrosAtivos() {
		return repo.contarQuantidadeDeTamanhos();
	}

	
    
}