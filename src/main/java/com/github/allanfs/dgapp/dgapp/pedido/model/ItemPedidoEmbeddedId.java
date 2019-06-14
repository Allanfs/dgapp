package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoEmbeddedId  implements Serializable {
	
	@Getter
	@Setter
	@ManyToOne()
	private Pedido pedido;
	
	@Getter
	@Setter
	@ManyToOne()
	private Produto produto;
	
	

}
