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
@Getter @Setter
public class Produto {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_produto",updatable = false)
	private UUID id;
	
	private String nome;
	
	private float preco;
	
	private Numerario valor;
}
