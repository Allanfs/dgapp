package com.github.allanfs.dgapp.dgapp.pizza.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;

public interface RecheioRepository extends JpaRepository<Recheio, UUID> {

	Optional<Recheio> findByNome( String nome );
}
