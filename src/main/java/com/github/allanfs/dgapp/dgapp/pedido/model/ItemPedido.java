package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Representa a relação entre um Pedido e um Produto.
 * {@link Produto}s podem ser adicionados no pedido através desta classe.</p>
 * <p>
 * Todo {@link ItemPedido} precisa de:
 * <ul>
 * 	<li>uma referencia ao {@link Pedido} que compoe</li>
 * 	<li>uma referencia ao {@link Produto}</li>
 * </ul>
 * <br>
 * Um pedido se relaciona com vários produtos, e um produto se relaciona com varios pedidos.
 * </p>
 * @author allan
 * @see Produto
 * @see Pedido
 *
 */
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"quantidade", "observacao"})
@Entity(name = "tb_item_pedido")
@Data
public class ItemPedido {

	@EmbeddedId
	@JsonIgnore
	private ItemPedidoEmbeddedId id;
	
	@OneToMany
	private List<SaborDeItemPedido> sabores;
	
	@OneToOne(targetEntity = Tamanho.class)
	private Tamanho tamanho;
	
	private int quantidade;
	
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
	
	public boolean quantidadeMaiorQueZero() {
		return this.quantidade > 0;
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

