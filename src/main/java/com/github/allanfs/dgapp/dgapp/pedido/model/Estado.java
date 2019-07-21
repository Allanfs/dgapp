package com.github.allanfs.dgapp.dgapp.pedido.model;

public enum Estado {
	ABERTO(1), FECHADO(0), CANCELADO(-1);

	private int estado;

	Estado(int estado) {
		this.estado = estado;
	}
	
	public boolean estaAberto() {
		return ABERTO.getValorEstado() == this.estado;
	}
	
	public boolean estaFechado() {
		return FECHADO.getValorEstado() == this.estado;
	}
	
	public boolean estaCancelado() {
		return CANCELADO.getValorEstado() == this.estado;
	}
	
	public int getValorEstado() {
		return this.estado;
	}
	
}
