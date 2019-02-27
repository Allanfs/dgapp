package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.allanfs.dgapp.modelo.CategoriaSabor;
import com.github.allanfs.dgapp.repository.CategoriaSaborRepository;
public class CategoriaSaborService implements IService<CategoriaSabor>{

    @Autowired
    private CategoriaSaborRepository categoriaRepo;

    public void cadastrar(CategoriaSabor categoria){
        categoriaRepo.save(categoria);
    }
    
    public void editar(CategoriaSabor categoria){
        categoriaRepo.save(categoria);
    }

    public List<CategoriaSabor> buscarTodos(){
        return categoriaRepo.findAll();
    }

    public CategoriaSabor buscarUm( Long id) {
        return categoriaRepo.findById( id ).get();
    }

}