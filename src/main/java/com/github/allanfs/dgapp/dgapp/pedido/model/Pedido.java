package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name="pedido_seq", sequenceName="pedido_codigo_seq", allocationSize=1)
public class Pedido {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido",updatable = false)
	@Getter
	@Setter
	private UUID id;
	
	@NotNull
	@Column(updatable = false)
	@Getter
	@Setter
	private Long codigo;
	
	@NotNull
	@Getter
	@Setter
	private Estado estado = Estado.FECHADO;
	
	@NotNull
	@Getter
	@Setter
	@Column(name="id_cliente_fk", updatable = false)
	private Cliente cliente;
	
	@NotNull
	@Column(name="id_endereco_fk")
	@Getter
	@Setter
	private Endereco endereco;
	
	@Column( updatable = false )
	@Temporal(TemporalType.TIMESTAMP)
	@Getter
	@Setter
	private Date horaAbertura;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="Estado_Seq")
	private int numeroPedido;
	
	@Column( updatable = false )
	@Temporal(TemporalType.TIMESTAMP)
	@Getter
	@Setter
	private Date horaFechamento;
	
	/**
	 * Operações de desconto ou acrescimo
	 * são feitos nesta classe.
	 */
	@Getter
	@Setter
	private List<Operacao> operacoes = new ArrayList<Operacao>();
	
	@OneToMany
	@Getter
	@Setter
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	@Getter
	@Setter
	private List<FormaPagamento> pagamentos = new ArrayList<FormaPagamento>();
	
	@Getter
	@Setter
	@Transient
	private float total;
	
	@Getter
	@Setter
	@Transient
	private float subtotal;
	
	@Getter
	@Setter
	@Transient
	private float valorPago;
	
}
