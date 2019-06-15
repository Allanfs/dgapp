package com.github.allanfs.dgapp.dgapp.pedido.model;

import javax.persistence.EmbeddedId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(exclude = {"quantidade", "observacao"})
public class ItemPedido {

	@EmbeddedId
	private ItemPedidoEmbeddedId id;
	
	@Getter
	@Setter
	private int quantidade;
	
	@Getter
	@Setter
	private String observacao;
	
	public ItemPedido(Pedido pedido, Produto produto) {
		this.id = new ItemPedidoEmbeddedId(pedido, produto);
		this.quantidade = 1;
	}

	public ItemPedido(Pedido pedido, Produto produto, int quantidade ) {
		this.id = new ItemPedidoEmbeddedId(pedido, produto);
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return criarIDSeNaoExistir().getProduto();
	}
	public void setProduto( Produto produto ) {
		criarIDSeNaoExistir().setProduto(produto);
	}
	
	public Pedido getPedido() {
		return criarIDSeNaoExistir().getPedido();
	}
	public void setPedido( Pedido pedido ) {
		criarIDSeNaoExistir().setPedido(pedido);
	}
	
	private ItemPedidoEmbeddedId criarIDSeNaoExistir() {
		if(id == null) {
			id = new ItemPedidoEmbeddedId();
		}
		return id;
	}
}
