package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.Expediente;
import com.github.allanfs.dgapp.dgapp.pedido.service.Numerario;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PedidoNovo {
	
	private UUID id;
	
	private String numeroPedido;
	
	private Date horaAbertura;
	private Date horaFechamento;
	
	private Cliente cliente;
	
	private Endereco endereco;
	
	private Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
	
	private List<Operacao> operacoes = new ArrayList<Operacao>();
	
	private Numerario total;
	private Numerario valorPago;
	private Expediente expediente;
	
	public PedidoNovo() {
		this.horaAbertura = Calendar.getInstance().getTime();
	}
	
}