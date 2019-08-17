package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.Data;

@Entity
//@Table(name = "tb_item_pedido_sabor")
@Data
public class SaborDeItemPedido {
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_sabor_item_de_pedido")
	private UUID id;

	@ManyToOne()
	@JsonIgnore
	private ItemPedido itemPedido;
	
	@ManyToOne()
	private Sabor sabor;
	

}
