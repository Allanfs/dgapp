package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.pedido.Produto;
import com.github.allanfs.dgapp.repository.ProdutoRepository;

@Service
public class ProdutoService implements IService<Produto>{

    @Autowired
    private ProdutoRepository produtoRepo;

    public Produto cadastrar(Produto Produto){
        return produtoRepo.save(Produto);
    }
    
    public Produto editar(Produto Produto){
        return produtoRepo.save(Produto);
    }

    public List<Produto> buscarTodos(){
        return produtoRepo.findAll();
    }

    public Produto buscarPorId( Long id) {
        return produtoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	produtoRepo.deleteById( id );
    }
    
}