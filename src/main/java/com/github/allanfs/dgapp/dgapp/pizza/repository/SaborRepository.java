package com.github.allanfs.dgapp.dgapp.pizza.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, UUID> {

	Optional<Sabor> findByNome( String nome );
	
}
