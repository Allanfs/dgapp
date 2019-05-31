package com.github.allanfs.dgapp.modelo.pedido;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_pedido_itempedido")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

	@EmbeddedId
	@Getter
	@Setter
	ItemPedidoEmbeddedKey id;

	@NotNull
	@Getter @Setter private Integer quantidade;
	@Getter @Setter private String observacao;
}
