package com.github.allanfs.dgapp.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Sabor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sabor")
	@Getter
	private Long id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private boolean especial;

	@ManyToMany
	@Getter
	@Setter
	private Set<Recheio> recheios;

	@OneToMany(cascade = CascadeType.PERSIST)
	@Getter
	@Setter
	private Set<SaborPreco> precosTamanhos;

	@ManyToOne
	@Getter
	@Setter
	private Categoria categoria;

}