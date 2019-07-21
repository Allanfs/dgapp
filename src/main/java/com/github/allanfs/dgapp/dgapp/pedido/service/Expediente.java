package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class Expediente {
	
	private UUID id;
	
	private Date horaAbertura;
	private Date horaFechamento;
	
	BigDecimal saldoInicial;
	BigDecimal saldoFinal;

}
