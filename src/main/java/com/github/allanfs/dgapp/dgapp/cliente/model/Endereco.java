package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_endereco")
	@Getter
	@Setter
	private UUID id;

	@NotNull
	@Getter
	@Setter
	private String rua;

	@NotNull
	@Getter
	@Setter
	private String bairro;
	
	@Getter
	@Setter
	private String complemento;

	@NotNull
	@Getter
	@Setter
	private String numero;

	@JsonIgnore
	@Getter
	@Setter
	private String cep;

}