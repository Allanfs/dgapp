package com.github.allanfs.dgapp.dgapp.pedido.service.exceptions;

import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;

public class ProibidoCancelarPedidoNoEstadoException extends Exception {

	public ProibidoCancelarPedidoNoEstadoException(Estado estado) {
		super("Não é permitido cancelar pedido no estado " + estado);
	}
	
}
