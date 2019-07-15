package com.github.allanfs.dgapp.dgapp.pizza.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;

@Repository
public interface RecheioRepository extends JpaRepository<Recheio, UUID> {

	Optional<Recheio> findByNome( String nome );

	@Query(value = "SELECT COUNT(*) FROM tb_recheio")
	Integer contarQuantidadeDeRecheios();
}
