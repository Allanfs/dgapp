package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, UUID>{

	Optional<Telefone> findByNumero( String numero );

	void deleteByNumero( String numero );
	
	List<Telefone> findByCliente( UUID idCliente );
	
	
}