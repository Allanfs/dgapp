package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * DinheiroPagamento
 */
@Entity
public class DinheiroPagamento extends FormaDePagamento {

  DinheiroPagamento(Pedido pedido, BigDecimal valor) {
    super(pedido, valor);
  }
  
}