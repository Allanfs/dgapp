package com.github.allanfs.dgapp.dgapp.pedido.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.ProdutoPizza;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(exclude = {"quantidade", "observacao"})
@Entity(name = "tb_item_pedido")
@Data
public class ItemPedido {

	@EmbeddedId
	@JsonIgnore
	private ItemPedidoEmbeddedId id;
	
	private int quantidade;
	
	private String observacao;

	private ProdutoPizza pizza;
	
	/**
	 * Tamanho é setado apenas se
	 * o produto for uma pizza
	 */
	@ManyToOne
	@JoinColumn(name="id_tamanho_fk")
	private Tamanho tamanho;

	
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
	
	@JsonIgnore
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
	
	/*
	 * MAPPED SUPER CLASS	caso a subclasse herde de um tipo que não seja entity
	 * 		toda classe que herdar desta classe, possuirá as colunas que a super tiver em atributo
	 * SINGLE TABLE			salva as subclasses em uma unica tabela
	 * 
	 * JOINED				uma tabela para cada entity da herança (não importa se é abstrata)
	 * 
	 * TABLE PER CLASS		uma tabela para cada classe concreta
	 */
}
