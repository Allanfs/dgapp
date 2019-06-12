package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID>{

	Telefone findByNumero( String numero );

	Set<Telefone> findByCliente( UUID idCliente );
}