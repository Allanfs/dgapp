package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
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
@Getter @Setter
class ItemPedidoEmbeddedId  implements Serializable {
	
	@ManyToOne()
	@JoinColumn(
			name="id_pedido_fk",
			referencedColumnName="id_pedido",
			foreignKey = @ForeignKey(
					name="id_pedido_fk_esta_para_id_pedido")
			)
	private Pedido pedido;
	
	@ManyToOne()
	@JoinColumn(name="id_produto_fk", referencedColumnName="id_produto",
		foreignKey = @ForeignKey(
				name="id_produto_fk_esta_para_id_produto")
		)
	private Produto produto;
	
	

}
