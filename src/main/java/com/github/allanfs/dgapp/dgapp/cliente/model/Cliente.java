package com.github.allanfs.dgapp.dgapp.cliente.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_cliente")
	@Getter
	@Setter
	private UUID id;

	@OneToMany(targetEntity = Telefone.class, mappedBy = "cliente")
	@Getter
	@Setter
	private Set<Telefone> telefone;

	@OneToMany(targetEntity = Endereco.class, mappedBy = "cliente")
	@Getter
	@Setter
	private Set<Endereco> endereco;

	@Getter
	@Setter
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Getter
	@Setter
	private Date dataNascimento;
	
	@Getter
	@Setter
	private String cpf;

	@Getter
	@Setter
	private String instagram;
	
	@Getter
	@Setter
	private String facebook;

	@Email
	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private Date dataCadastro;

}
