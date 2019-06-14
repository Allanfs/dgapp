package com.github.allanfs.dgapp.dgapp.pedido.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
