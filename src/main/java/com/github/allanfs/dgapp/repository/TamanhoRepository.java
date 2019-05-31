package com.github.allanfs.dgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.modelo.pizza.Tamanho;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long>{

    
}