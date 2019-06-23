package com.github.allanfs.dgapp.dgapp.pedido.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.service.Expediente;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

	List<Pedido> findByEstado(Estado estado);
	
	List<Pedido> findByCliente(Cliente cliente);
	
//	List<Pedido> findByExpediente(Expediente expediente);
	
	List<Pedido> findByTotalGreaterThanEqual(BigDecimal valor);
	
	List<Pedido> findByTotalLessThanEqual(BigDecimal valor);
	
}
