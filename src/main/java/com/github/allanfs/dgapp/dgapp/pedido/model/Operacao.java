package com.github.allanfs.dgapp.dgapp.pedido.model;

import lombok.Setter;

public enum Operacao {
	DESCONTO , COBRANCA ;

	@Setter
	private float valor;
	
	public float getValor() {
		if (this == COBRANCA) {
			return -this.valor;
		}else {
			return +this.valor;
		}
	}

}
