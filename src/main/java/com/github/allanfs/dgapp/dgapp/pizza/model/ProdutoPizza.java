package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.github.allanfs.dgapp.dgapp.pedido.model.ItemPedidoSabor;
import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;

import lombok.Data;

/**
 * <p>Representa um {@link Produto} marcado como pizza, o qual pode
 * ser adicionado {@linkplain Sabor Sabores}, e um {@link Tamanho}.</p>
 * <p>Os sabores são adicionados por {@link ItemPedidoSabor}, a qual
 * representa a relação entre um {@link Sabor} e um {@link ProdutoPizza} </p>
 * @see Produto
 * @see ItemPedidoSabor
 * 
 */
@Entity(name="tb_produto_pizza")
@Data
public class ProdutoPizza extends Produto {

  @ManyToOne
  @JoinColumn(name="id_tamanho_fk")
  private Tamanho tamanho;

  @ManyToMany
  @JoinColumn(name="id_sabor_fk")
  private List<ItemPedidoSabor> sabores;
  
  public ProdutoPizza() {
	  this.setPizza(true);
  }
  
}