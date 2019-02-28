package com.github.allanfs.dgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    
}