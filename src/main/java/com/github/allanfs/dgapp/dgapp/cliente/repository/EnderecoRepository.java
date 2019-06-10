package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

public interface EnderecoRepository  extends JpaRepository<Endereco, UUID>{

}
