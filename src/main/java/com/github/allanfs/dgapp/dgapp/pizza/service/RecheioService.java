package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.UUID;

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
        return recheioRepo.findById( id ).orElse(null);
    }
    
    public void deletar( UUID id ) {
    	recheioRepo.deleteById( id );
    }
    
}