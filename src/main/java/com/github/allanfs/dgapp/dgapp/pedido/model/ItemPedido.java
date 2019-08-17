package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_item_pedido")
	private UUID id;
	
	@ManyToOne()
	@JoinColumn(
			name="id_pedido_fk",
			referencedColumnName="id_pedido",
			foreignKey = @ForeignKey(
					name="id_pedido_fk_esta_para_id_pedido")
			)
	@JsonIgnore
	private Pedido pedido;
	
	@ManyToOne()
	@JoinColumn(name="id_produto_fk", referencedColumnName="id_produto",
		foreignKey = @ForeignKey(
				name="id_produto_fk_esta_para_id_produto")
		)
	private Produto produto;
	
	@OneToMany(cascade = CascadeType.ALL)	
	private List<SaborDeItemPedido> sabores;
	
	@OneToOne(targetEntity = Tamanho.class)
	private Tamanho tamanho;
	
	private int quantidade;
	
	private String observacao;

	public ItemPedido(Pedido pedido, Produto produto) {
//		this.id = new ItemPedidoEmbeddedId(pedido, produto);
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = 1;
	}

	public ItemPedido(Pedido pedido, Produto produto, int quantidade ) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
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

