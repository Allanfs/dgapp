package com.github.allanfs.dgapp.dgapp.pedido.model;

import javax.persistence.EmbeddedId;

import lombok.Getter;
import lombok.Setter;

public class ItemPedido {

	@EmbeddedId
	private ItemPedidoEmbeddedId id;
	
	@Getter
	@Setter
	private int quantidade;
	
	@Getter
	@Setter
	private String observacao;
}
