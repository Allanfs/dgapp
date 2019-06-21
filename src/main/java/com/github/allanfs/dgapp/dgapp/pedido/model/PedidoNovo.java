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

public class PedidoNovo {
	
	@Getter @Setter private UUID id;
	
	@Getter @Setter private String numeroPedido;
	
	@Getter @Setter private Date horaAbertura;
	@Getter @Setter private Date horaFechamento;
	
	@Getter @Setter private Cliente cliente;
	
	@Getter @Setter private Endereco endereco;
	
	@Getter @Setter private Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
	
	@Getter @Setter private List<Operacao> operacoes = new ArrayList<Operacao>();
	
	@Getter @Setter private Numerario total;
	@Getter @Setter private Numerario valorPago;
	
	@Getter @Setter private Expediente expediente;
	
	public PedidoNovo() {
		this.horaAbertura = Calendar.getInstance().getTime();
	}
	
}