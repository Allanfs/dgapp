package com.github.allanfs.dgapp.dgapp.pedido.repository;

import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
