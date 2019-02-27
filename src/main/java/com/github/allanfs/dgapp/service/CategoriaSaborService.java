package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.allanfs.dgapp.modelo.CategoriaSabor;
import com.github.allanfs.dgapp.repository.CategoriaSaborRepository;
public class CategoriaSaborService implements IService<CategoriaSabor>{

    @Autowired
    private CategoriaSaborRepository categoriaRepo;

    public CategoriaSabor cadastrar(CategoriaSabor categoria){
        return categoriaRepo.save(categoria);
    }
    
    public CategoriaSabor editar(CategoriaSabor categoria){
        return categoriaRepo.save(categoria);
    }

    public List<CategoriaSabor> buscarTodos(){
        return categoriaRepo.findAll();
    }

    public CategoriaSabor buscarPorId( Long id) {
        return categoriaRepo.findById( id ).get();
    }
    
    public void deletar( Long id ) {
    	categoriaRepo.deleteById( id );
    }
    
}