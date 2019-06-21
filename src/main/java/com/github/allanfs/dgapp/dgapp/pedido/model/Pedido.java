package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_pedido")
@Getter	@Setter
public class Pedido {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido", updatable = false)
	private UUID id;

	@Column(updatable = false)
	@Transient
	private Long codigo;

	@NotNull
	private Estado estado = Estado.FECHADO;

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
	private Map<Produto,Integer> itens = new HashMap<Produto,Integer>();

	private List<Pagamento> pagamentos;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaAbertura;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFechamento;

	@Transient
	private float total;

	@Transient
	private float subtotal;

	@Transient
	private float valorPago;
	

}
