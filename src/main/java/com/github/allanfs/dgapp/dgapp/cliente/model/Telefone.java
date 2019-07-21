package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_telefone")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cliente" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"cliente"})
@Getter @Setter
public class Telefone {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_telefone")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	@NotNull
	private Cliente cliente;
 
	private Integer ddd;
	@NotNull
	private String numero;
	private boolean whatsapp;
	private String observacao;

}
