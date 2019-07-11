package com.github.allanfs.dgapp.dgapp.pedido.service.exceptions;

import lombok.NoArgsConstructor;

/**
 * CancelamentoDePedidoException
 */
@NoArgsConstructor
public class CancelamentoDePedidoException extends RuntimeException {

  public CancelamentoDePedidoException(String message) {
    super(message);
  }

}