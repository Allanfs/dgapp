package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_pagamentos")
@NoArgsConstructor
public class FormaDePagamento {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pagamento")
	protected UUID id;
	protected BigDecimal valorPago;
	
	protected Date hora;
	
	@OneToOne(mappedBy = "pagamento")
	protected Pedido pedido;
	
	FormaDePagamento(Pedido pedido, BigDecimal valor){
		pedido.setPagamento(this);
		this.valorPago = valor;
	}
	
}
