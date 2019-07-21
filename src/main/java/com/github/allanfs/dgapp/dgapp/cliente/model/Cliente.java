package com.github.allanfs.dgapp.dgapp.cliente.model;

import static javax.persistence.CascadeType.ALL;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="tb_cliente")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(exclude = {"telefone", "endereco"})
public class Cliente {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_cliente",updatable = false)
	private UUID id;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Telefone.class, mappedBy = "cliente", orphanRemoval = true, cascade = {ALL})
	@Builder.Default
	private Set<Telefone> telefone = new HashSet<Telefone>();

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Endereco.class, mappedBy = "cliente", orphanRemoval = true, cascade = {ALL})
	@Builder.Default
	private Set<Endereco> endereco = new HashSet<Endereco>();

	@NotNull
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataNascimento;
	
	private String cpf;

	private String instagram;
	
	private String facebook;

	@Email
	private String email;

	@Column( insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

}
