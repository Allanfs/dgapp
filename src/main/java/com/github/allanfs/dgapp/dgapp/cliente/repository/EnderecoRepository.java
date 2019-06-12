package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
@Repository

public interface EnderecoRepository  extends JpaRepository<Endereco, UUID>{

}
