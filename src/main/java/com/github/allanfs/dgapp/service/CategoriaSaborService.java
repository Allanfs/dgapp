package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.CategoriaSabor;
import com.github.allanfs.dgapp.repository.CategoriaSaborRepository;

@Service
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
        return categoriaRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	categoriaRepo.deleteById( id );
    }
    
}