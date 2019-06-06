package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.UUID;

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
        return tamanhoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( UUID id ) {
    	tamanhoRepo.deleteById( id );
    }
    
}