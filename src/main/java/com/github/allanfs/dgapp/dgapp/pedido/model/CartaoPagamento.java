package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * CartaoPagamento
 */
@Entity
public class CartaoPagamento extends FormaDePagamento {
  
  private String bandeira;

  CartaoPagamento(Pedido pedido, BigDecimal valor) {
    super(pedido, valor);
  }

  CartaoPagamento(Pedido pedido, BigDecimal valor, String bandeira) {
    super(pedido, valor);
    this.bandeira = bandeira;
  }
  
}