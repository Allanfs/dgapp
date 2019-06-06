package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.repository.SaborRepository;

@Service
public class SaborService implements IService<Sabor>{

    @Autowired
    private SaborRepository saborRepo;

    public Sabor cadastrar(Sabor Sabor){
        return saborRepo.save(Sabor);
    }
    
    public Sabor editar(Sabor Sabor){
        return saborRepo.save(Sabor);
    }

    public List<Sabor> buscarTodos(){
        return saborRepo.findAll();
    }

    public Sabor buscarPorId( UUID id) {
        return saborRepo.findById( id ).orElse(null);
    }
    
    public void deletar( UUID id ) {
    	saborRepo.deleteById( id );
    }
    
}