package com.github.allanfs.dgapp.dgapp.pedido.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

	List<Pedido> findByEstado(Estado estado);
	
	List<Pedido> findByCliente(UUID id);	// vai ter que fazer uma consulta pra buscar os pedidos de um cliente por ID
	
//	List<Pedido> findByExpediente(Expediente expediente);
	
	List<Pedido> findByTotalGreaterThanEqual(BigDecimal valor);
	
	List<Pedido> findByTotalLessThanEqual(BigDecimal valor);
	
}
