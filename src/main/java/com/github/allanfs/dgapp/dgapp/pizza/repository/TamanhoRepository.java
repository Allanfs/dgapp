package com.github.allanfs.dgapp.dgapp.pizza.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

public interface TamanhoRepository extends JpaRepository<Tamanho, UUID> {

}
