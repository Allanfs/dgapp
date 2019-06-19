package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_codigo_seq", allocationSize = 1)
public class Pedido {

	@Id
	@Getter	@Setter
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido", updatable = false)
	private UUID id;

	@NotNull
	@Getter	@Setter
	@Column(updatable = false)
	private Long codigo;

	@NotNull
	@Getter	@Setter
	private Estado estado = Estado.FECHADO;

	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Estado_Seq")
	private int numeroPedido;

	@NotNull
	@Getter	@Setter
	@OneToOne(targetEntity = Cliente.class)
	private Cliente cliente;

	@NotNull
	@Getter	@Setter
	@OneToOne(targetEntity = Endereco.class)
	private Endereco endereco;

	@Getter	@Setter
	@OneToMany(targetEntity = ItemPedido.class, mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();

	@Getter	@Setter
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaAbertura;

	@Getter	@Setter
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFechamento;

	@Transient
	@Getter	@Setter
	private float total;

	@Transient
	@Getter	@Setter
	private float subtotal;

	@Transient
	@Getter	@Setter
	private float valorPago;

}
