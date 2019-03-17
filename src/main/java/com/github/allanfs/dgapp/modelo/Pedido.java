package com.github.allanfs.dgapp.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.engine.internal.ForeignKeys;
import org.hibernate.mapping.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido")
	@Getter private Long id;
	
	@NotNull
	@JoinColumn( name="id_cliente_fk")
	@OneToOne(targetEntity=Cliente.class)
	@Getter @Setter private Cliente cliente;
	
	@NotNull
	@OneToOne(targetEntity=Endereco.class)
	@JoinColumn( name="id_endereco_fk")
	@Getter @Setter private Endereco enderecoEntrega;
	
	@OneToMany(cascade= CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn( name="id_itempedido")
	private Set<ItemPedido> itemPedido;
	
	@Column(name="dt_pedido")
	@Getter @Setter private Date dataPedido;
	
}
