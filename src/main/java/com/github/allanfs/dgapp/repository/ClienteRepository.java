package com.github.allanfs.dgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}