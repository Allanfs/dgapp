package com.github.allanfs.dgapp.dgapp.pedido.service.exceptions;

import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PedidoException extends RuntimeException {
	
	private Pedido pedido;
	private String message;
	public PedidoException(String message) {
	    super(message);
	    this.message = message;
	  }
}
