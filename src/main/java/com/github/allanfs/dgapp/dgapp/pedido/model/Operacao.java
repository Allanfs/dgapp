package com.github.allanfs.dgapp.dgapp.pedido.model;

public enum Operacao {
	DESCONTO , COBRANCA ;

	private float valor;
	
	public float getValor() {
		if (this == COBRANCA) {
			if (this.valor > 0) {
				return this.valor;
			}else {
				return this.valor * -1;
			}
		}else {
			if (this.valor > 0) {
				return this.valor * -1;
			}else {
				return this.valor;
			}
		}
	}
	
	public Operacao setValor(float valor) {
		this.valor = valor;
		return this;
	}
	
	public boolean ehDesconto() {
		if (this == DESCONTO) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ehCobranca() {
		if (this == Operacao.COBRANCA) {
			return true;
		}else {
			return false;
		}
	}

}
