package com.github.allanfs.dgapp.dgapp.pedido.service.exceptions;

import lombok.NoArgsConstructor;

/**
 * CancelamentoDePedidoException
 */
@NoArgsConstructor
public class CancelamentoDePedidoException extends PedidoException {

  public CancelamentoDePedidoException(String message) {
    super(message);
  }

}