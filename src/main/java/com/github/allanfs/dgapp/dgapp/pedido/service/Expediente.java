package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;

import lombok.Data;

@Data
public class Expediente {
	
	private UUID id;
	
	private Date horaAbertura;
	private Date horaFechamento;
	
	BigDecimal saldoInicial;
	BigDecimal saldoFinal;
	
	

}
