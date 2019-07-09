package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public abstract class FormaDePagamento {

	protected BigDecimal valor;
	
	protected Date hora;
	
	protected Pedido pedido;
	
	FormaDePagamento(Pedido pedido, BigDecimal valor){
		pedido.setPagamento(this);
		this.valor = valor;
	}
	
}
