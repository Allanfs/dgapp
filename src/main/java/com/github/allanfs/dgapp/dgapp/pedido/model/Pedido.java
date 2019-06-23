package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.Expediente;

import lombok.Data;

@Data
@Entity(name="tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido", updatable = false)
	private UUID id;
	
	@Enumerated
	private Estado estado;
	
	private String numeroPedido;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaAbertura;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFechamento;
	
	@NotNull
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente_fk")
	private Cliente cliente;
	
	@NotNull
	@OneToOne(targetEntity = Endereco.class)
	@JoinColumn(name="id_endereco_fk")
	private Endereco endereco;
	
	@ElementCollection
	@JoinTable(
			name="tabela_produtos_pedido", 
			joinColumns = {@JoinColumn(name="id_pedido_fk",referencedColumnName = "id_pedido")})
	@Column(name="quantidadeItens")
	private Map<Produto, Integer> itens = new HashMap<Produto, Integer>();
	
	@Transient
	private List<Operacao> operacoes = new ArrayList<Operacao>();
	
	@Transient
	private FormaDePagamento pagamento;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@Column(name = "valorPago")
	private BigDecimal valorPago;
	
	@Transient
	private Expediente expediente;
	
	public Pedido() {
		this.horaAbertura = Calendar.getInstance().getTime();
		this.estado = Estado.ABERTO;
		
	}
	
}