package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(exclude = {"quantidade", "observacao"})
@Entity(name = "tb_item_pedido")
@Data
public class ItemPedido {

	@EmbeddedId
	private ItemPedidoEmbeddedId id;
	
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
