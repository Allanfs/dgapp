package com.github.allanfs.dgapp.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@Getter private Long id;
	
	@NotNull
	@OneToOne(targetEntity=Cliente.class)
	@Getter @Setter private Cliente cliente;
	
	@NotNull
	@OneToOne(targetEntity=Endereco.class)
	@Getter @Setter private Endereco enderecoEntrega;
	
	
	@Getter @Setter private Date dataPedido;
	
}
