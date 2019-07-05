package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="tb_produto")
@Data
public class Produto {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_produto",updatable = false)
	private UUID id;
	
	private String nome;
	
	private float preco;
	
	private BigDecimal valor;
}
