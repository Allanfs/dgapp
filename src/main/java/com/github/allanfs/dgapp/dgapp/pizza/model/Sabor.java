package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
@NoArgsConstructor @AllArgsConstructor
public class Sabor extends TipoInsumo{
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_sabor")
	@Getter	@Setter	UUID id;
	@Getter @Setter private String nome;
	
	@ManyToMany
	@Getter @Setter private Set<Recheio> recheios;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@Getter @Setter private Set<SaborPrecoTamanho> precosTamanhos;
}
