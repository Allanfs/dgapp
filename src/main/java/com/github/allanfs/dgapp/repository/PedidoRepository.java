package com.github.allanfs.dgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}