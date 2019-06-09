package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
@NoArgsConstructor @AllArgsConstructor
public class Sabor extends TipoInsumo{

	@Id
	@GeneratedValue(generator = "UUID",strategy = GenerationType.AUTO)
	@Column(name="id_sabor")
	@Getter	@Setter	UUID id;
	@Getter @Setter private String nome;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JsonManagedReference
	@Getter @Setter private Set<SaborOrdemRecheio> recheios;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@Getter @Setter private Set<SaborPrecoTamanho> precosTamanhos;
	
	@Override
	public String toString() {
		return "Sabor [id=" + id + ", nome=" + nome + ", recheios=" + recheios + ", precosTamanhos=" + precosTamanhos
				+ "]";
	}
}
