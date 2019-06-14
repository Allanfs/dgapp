package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_endereco")
	@Getter
	@Setter
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	@Getter
	@Setter
	@NotNull
	private Cliente cliente;
	
	@NotNull(message = "Rua deve ser preenchida")
	@Getter
	@Setter
	private String rua;

	@NotNull(message = "Bairro deve ser preenchido")
	@Getter
	@Setter
	private String bairro;
	
	@Getter
	@Setter
	private String complemento;

	@NotNull(message = "Número deve ser preenchido")
	@Getter
	@Setter
	private String numero;

	@JsonIgnore
	@Getter
	@Setter
	private String cep;

}