package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;

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
	private Date horaAbertura = null;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFechamento = null;
	
	@NotNull
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente_fk")
	private Cliente cliente;
	
	@NotNull
	@OneToOne(targetEntity = Endereco.class)
	@JoinColumn(name="id_endereco_fk")
	private Endereco endereco;
	
	@JoinColumn(name = "id_itempedido")
	@OneToMany
	private List<ItemPedido> itens;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@Column(name = "valorPago")
	private BigDecimal valorPago;
	
	public Pedido() {
		this.horaAbertura = Calendar.getInstance().getTime();
		this.estado = Estado.ABERTO;
		
	}
	
	/* public int getQuantidadeItem(Produto p){
		Optional<ItemPedido> itemOpt = this.itens.stream().filter( item -> item.getProduto().equals(p)).findFirst();

		if (itemOpt.isPresent()) {
			return itemOpt.get().getQuantidade();
		}else{
			return -1;
		}
		
	}
	public void setItem(Produto p) {
		int qtd = this.getQuantidadeItem(p);
		if ( qtd < 0 )  {
			this.itens.add( new ItemPedido(this, p) );
		}else{
			this.itens.stream().filter( item -> item.getProduto().equals(p) ).findFirst().get().setQuantidade(++qtd);
		} 
	}*/
	
	
}