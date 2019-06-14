package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

	List<Cliente> findByNome(String nome);
}
