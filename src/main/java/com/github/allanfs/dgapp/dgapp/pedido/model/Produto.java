package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tb_produto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_produto",updatable = false)
	private UUID id;
	
	private String nome;
	
	private BigDecimal preco;
	
}
