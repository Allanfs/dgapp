package com.github.allanfs.dgapp.modelo;

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
@Table(name="")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@Getter @Setter private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto")
	@Getter @Setter private Produto produto;

	@NotNull
	@Getter @Setter private Integer quantidade;
	@Getter @Setter private String observacao;
}
