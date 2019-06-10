package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_telefone")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_telefone")
	@Getter
	@Setter
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	@Getter
	@Setter
	private Cliente cliente;

	@Getter
	@Setter
	private Integer ddd;
	@Getter
	@Setter
	private String numero;
	@Getter
	@Setter
	private boolean whatsapp;
	@Getter
	@Setter
	private String observacao;

}
