package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

import lombok.Data;

@Data
@Entity(name="tb_pedido")
public class Pedido implements Serializable {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_pedido")
	private UUID id;
	
	@Enumerated
	@JsonProperty("estado")
	private Estado estado;
	
	@JsonProperty("numero_pedido")
	private String numeroPedido;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("hora_abertura")
	private Date horaAbertura = null;
	
	@Column()
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("hora_fechamento")
	private Date horaFechamento = null;
	
	@NotNull
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente_fk")
	@JsonProperty("cliente")
	private Cliente cliente;
	
	@NotNull
	@OneToOne(targetEntity = Endereco.class)
	@JoinColumn(name="id_endereco_fk")
	@JsonProperty("endereco")
	private Endereco endereco;
	
	@JoinColumn(name = "id_itempedido")
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("itens")
	private List<ItemPedido> itens;
	
	@Column(name = "total")
	@JsonProperty("total")
	private BigDecimal total;
	
	@Column(name = "valorPago")
	@JsonProperty("valor_pago")
	private BigDecimal valorPago;

	@OneToOne
	@JsonProperty("pagamento")
	private FormaDePagamento pagamento;
	
	/**
	 * o   motivo  do cancelamento só será preenchido
	 * quando o pedido    realmente    for cancelado.
	 * Caso contrário,     permanecerá          null.
	 * Um  pedido  só   é cancelado se, e somente se,
	 * o motivo do cancelamento tenha sido informado,
	 * para     então   alterar o status do   pedido.
	 */
	@Column(name = "cancelamento")
	@JsonProperty("motivo_cancelamento")
	private String motivoCancelamento;

	
}