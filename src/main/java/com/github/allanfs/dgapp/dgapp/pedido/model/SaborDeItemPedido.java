package com.github.allanfs.dgapp.dgapp.pedido.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

@Entity
@Table(name = "tb_item_pedido_sabor")
public class SaborDeItemPedido {
	@JsonIgnore
	@EmbeddedId
	public SDIPEmbeddedId id;

	public ItemPedido getItemPedido() {
		if (this.id == null) {
			return null;
		} else {
			return this.id.getItemPedido();
		}
	}

	public void setItemPedido(ItemPedido item) {
		if (this.id == null) {
			this.id = new SDIPEmbeddedId();
		}
		this.id.setItemPedido(item);

	}

	public Sabor getSabor() {
		if (this.id == null) {
			return null;
		} else {
			return this.id.getSabor();
		}
	}

	public void setSabor(Sabor sabor) {
		if (this.id == null) {
			this.id = new SDIPEmbeddedId();
		}
		this.id.setSabor(sabor);
	}

}
