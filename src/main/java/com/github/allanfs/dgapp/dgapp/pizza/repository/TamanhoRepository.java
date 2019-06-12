package com.github.allanfs.dgapp.dgapp.pizza.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, UUID> {

	Optional<Tamanho> findByNome( String nome);
}
