package com.github.allanfs.dgapp.dgapp.pedido.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

	List<Pedido> findByEstado(Estado estado);
	
	List<Pedido> findByCliente(UUID id);	// vai ter que fazer uma consulta pra buscar os pedidos de um cliente por ID
	
//	List<Pedido> findByExpediente(Expediente expediente);
	
	List<Pedido> findByTotalGreaterThanEqual(BigDecimal valor);
	
	List<Pedido> findByTotalLessThanEqual(BigDecimal valor);

	@Query(value = "SELECT COUNT(*) FROM tb_pedido")
	Integer contarQuantidadeDePedidos();
	
	Integer countByEstado(Estado estado);
	
}
