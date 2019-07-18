package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.github.allanfs.dgapp.dgapp.pizza.model.ProdutoPizza;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.Data;

/**
 * <p>Representa a relação entre um {@link Sabor} e um {@link ProdutoPizza}.</p>
 * <p>Um {@link ProdutoPizza} pode possuir vários sabores, e um {@link Sabor} pode estar presente
 * em vários {@link ProdutoPizza}.</p>
 * <p>Deve possuir referencia tanto ao {@link Produto} tanto ao {@link Pedido} que está relacionado.
 * Observe que representam chaves estrangeiras no mapeamente JPA</p>
 */
@Entity(name="tb_item_sabor")
@Data
public class ItemPedidoSabor {

  @Id
  @GeneratedValue(generator = "uuid")
  private UUID id;
  
  @Embedded
  private ItemPedidoEmbeddedId itemPedidoId;

  @ManyToOne
  @JoinColumn(name="id_sabor_fk")
  private Sabor sabor;
  
}