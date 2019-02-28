package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.Categoria;
import com.github.allanfs.dgapp.repository.CategoriaRepository;

@Service
public class CategoriaService implements IService<Categoria>{

    @Autowired
    private CategoriaRepository categoriaRepo;

    public Categoria cadastrar(Categoria categoria){
        return categoriaRepo.save(categoria);
    }
    
    public Categoria editar(Categoria categoria){
        return categoriaRepo.save(categoria);
    }

    public List<Categoria> buscarTodos(){
        return categoriaRepo.findAll();
    }

    public Categoria buscarPorId( Long id) {
        return categoriaRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	categoriaRepo.deleteById( id );
    }
    
}