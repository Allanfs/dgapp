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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id_cliente",updatable = false)
	@Getter
	@Setter
	private UUID id;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Telefone.class, mappedBy = "cliente", orphanRemoval = true, cascade = {ALL})
	@Getter
	@Setter
	@Builder.Default
	private Set<Telefone> telefone = new HashSet<Telefone>();

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Endereco.class, mappedBy = "cliente", orphanRemoval = true, cascade = {ALL})
	@Getter
	@Setter
	@Builder.Default
	private Set<Endereco> endereco = new HashSet<Endereco>();

	@Getter
	@Setter
	@NotNull
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
	@Column( insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

}
