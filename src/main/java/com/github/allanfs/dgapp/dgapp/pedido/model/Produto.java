package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.allanfs.dgapp.dgapp.pedido.service.Numerario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_produto")
@EqualsAndHashCode
public class Produto {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_produto",updatable = false)
	@Getter
	@Setter
	private UUID id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private float preco;
	
	@Getter
	@Setter
	private Numerario valor;
}
