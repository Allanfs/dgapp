package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.Tamanho;
import com.github.allanfs.dgapp.repository.TamanhoRepository;

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

    public Tamanho buscarPorId( Long id) {
        return tamanhoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	tamanhoRepo.deleteById( id );
    }
    
}