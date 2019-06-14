package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido",updatable = false)
	@Getter
	@Setter
	private UUID id;
	
	@NotNull
	@Column(updatable = false)
	private Long codigo;
	
	@NotNull
	private boolean aberto;
	
	@NotNull
	@Column(name="id_cliente_fk", updatable = false)
	private Cliente cliente;
	
	@NotNull
	@Column(name="id_endereco_fk")
	private Endereco endereco;
	
	@Column( updatable = false )
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaAbertura;
	
	@Column( updatable = false )
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFechamento;
	
	
	/**
	 * Operações de desconto ou acrescimo
	 * são feitos nesta classe.
	 */
	@Getter
	@Setter
	private List<Operacao> operacoes;
	
	@OneToMany
	@Getter
	@Setter
	private Set<ItemPedido> itens;
	
}
