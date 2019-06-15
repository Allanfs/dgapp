package com.github.allanfs.dgapp.dgapp.pedido.model;

import lombok.Getter;
import lombok.Setter;

public enum Operacao {
	DESCONTO , COBRANCA ;

	@Getter
	@Setter
	private float valor;

}
