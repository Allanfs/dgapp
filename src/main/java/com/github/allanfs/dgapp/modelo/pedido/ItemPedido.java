package com.github.allanfs.dgapp.modelo.pedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_pedido_itempedido")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_itempedido")
	@Getter private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pedido_fk")
	@Getter @Setter private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto_fk")
	@Getter @Setter private Produto produto;

	@NotNull
	@Getter @Setter private Integer quantidade;
	@Getter @Setter private String observacao;
}
