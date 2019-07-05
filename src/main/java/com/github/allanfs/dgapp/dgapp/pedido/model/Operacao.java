package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;

public enum Operacao {
	DESCONTO , COBRANCA ;

	private BigDecimal valor;
	
	public BigDecimal getValor() {
		if (this == COBRANCA) {
			if (this.valor.compareTo( new BigDecimal(0) )  > 0 ) {
				return this.valor;
			}else {
				return this.valor.negate();
			}
		}else {
			if (this.valor.compareTo( new BigDecimal(0) )  > 0 ) {
				return this.valor.negate();
			}else {
				return this.valor;
			}
		}
	}
	
	public Operacao setValor(BigDecimal valor) {
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
