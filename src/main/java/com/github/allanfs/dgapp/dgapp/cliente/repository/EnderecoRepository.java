package com.github.allanfs.dgapp.dgapp.cliente.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
@Repository

public interface EnderecoRepository  extends JpaRepository<Endereco, UUID>{

	@Query(nativeQuery = true, value = "SELECT * FROM tb_endereco as endereco WHERE endereco.id_cliente_fk=?1")
	List<Endereco> buscarEnderecosDoCliente(String id);
	
}
