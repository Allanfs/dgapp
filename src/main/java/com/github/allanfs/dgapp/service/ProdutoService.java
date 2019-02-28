package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.Produto;
import com.github.allanfs.dgapp.repository.ProdutoRepository;

@Service
public class ProdutoService implements IService<Produto>{

    @Autowired
    private ProdutoRepository ProdutoRepo;

    public Produto cadastrar(Produto Produto){
        return ProdutoRepo.save(Produto);
    }
    
    public Produto editar(Produto Produto){
        return ProdutoRepo.save(Produto);
    }

    public List<Produto> buscarTodos(){
        return ProdutoRepo.findAll();
    }

    public Produto buscarPorId( Long id) {
        return ProdutoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	ProdutoRepo.deleteById( id );
    }
    
}