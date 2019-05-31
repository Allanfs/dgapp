package com.github.allanfs.dgapp.modelo.pedido;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor @NoArgsConstructor
public class ItemPedidoEmbeddedKey implements Serializable {

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pedido_fk")
	@Getter @Setter private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto_fk")
	@Getter @Setter private Produto produto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoEmbeddedKey other = (ItemPedidoEmbeddedKey) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
}
