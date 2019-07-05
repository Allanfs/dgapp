package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.Date;
import java.util.Set;
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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tb_endereco")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Endereco {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_endereco")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	@NotNull
	private Cliente cliente;
	
	@NotNull(message = "Rua deve ser preenchida")
	private String rua;

	@NotNull(message = "Bairro deve ser preenchido")
	private String bairro;
	
	private String complemento;

	@NotNull(message = "Número deve ser preenchido")
	private String numero;

	@JsonIgnore
	private String cep;

}