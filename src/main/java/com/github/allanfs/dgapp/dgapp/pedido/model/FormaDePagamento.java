package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public abstract class FormaDePagamento {

	private BigDecimal valor;
	
	private Date hora;
	
	private Pedido pedido;
	
	FormaDePagamento(Pedido pedido, BigDecimal valor){
//		pedido.setPagamento(this);
		this.valor = valor;
	}
	
}
