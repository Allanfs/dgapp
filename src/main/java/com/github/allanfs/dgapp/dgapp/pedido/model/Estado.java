package com.github.allanfs.dgapp.dgapp.pedido.model;

public enum Estado {
	ABERTO(1), FECHADO(0);

	private int estado;

	Estado(int estado) {
		this.estado = estado;
	}
}
