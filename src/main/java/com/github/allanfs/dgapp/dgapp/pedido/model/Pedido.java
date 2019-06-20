package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
public class Pedido {

	@Id
	@Getter	@Setter
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido", updatable = false)
	private UUID id;

	@Getter	@Setter
	@Column(updatable = false)
	@Transient
	private Long codigo;

	@NotNull
	@Getter	@Setter
	private Estado estado = Estado.FECHADO;

	@NotNull
	@Getter	@Setter
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente_fk")
	private Cliente cliente;

	@NotNull
	@Getter	@Setter
	@OneToOne(targetEntity = Endereco.class)
	@JoinColumn(name="id_endereco_fk")
	private Endereco endereco;

	@Getter	@Setter
	@ElementCollection
	@JoinTable(
			name="tabela_produtos_pedido", 
			joinColumns = {@JoinColumn(name="id_pedido_fk",referencedColumnName = "id_pedido")})
	@Column(name="quantidadeItens")
	private Map<Produto,Integer> itens = new HashMap<Produto,Integer>();

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
