package com.github.allanfs.dgapp.dgapp.pedido.service.exceptions;

import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;

public class ProibidoAlterarPedidoNoEstadoException extends PedidoException {

	public ProibidoAlterarPedidoNoEstadoException(Estado estado) {
		super("Não é permitido alterar pedido no estado " + estado);
	}
}
