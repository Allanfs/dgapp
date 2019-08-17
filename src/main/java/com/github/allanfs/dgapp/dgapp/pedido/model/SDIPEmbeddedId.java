package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.Data;

@Embeddable
@Data
public class SDIPEmbeddedId implements Serializable {
	@ManyToOne()
	private ItemPedido itemPedido;
	
	@ManyToOne()
	private Sabor sabor;
}
