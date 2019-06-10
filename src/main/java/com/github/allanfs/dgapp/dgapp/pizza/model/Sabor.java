package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
@NoArgsConstructor
@AllArgsConstructor
public class Sabor extends TipoInsumo {

	@Getter
	@Setter
	@Id
	@Column(name = "id_sabor")
	@GeneratedValue(generator = "UUID")
	UUID id;
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	@OneToMany(mappedBy= "id.sabor",
			fetch=FetchType.EAGER, 
			cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<SaborOrdemRecheio> recheios = new HashSet<SaborOrdemRecheio>();

	@Getter
	@Setter
	@OneToMany(mappedBy= "id.sabor",
			fetch=FetchType.EAGER, 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<SaborPrecoTamanho> precos = new HashSet<SaborPrecoTamanho>();

	public void adicionarRecheio(Recheio recheio, int posicao) {
		recheios.add(new SaborOrdemRecheio(recheio, posicao));
	}

	public void removerRecheioNaPosicao(int posicao) {
		recheios.removeIf(sor -> sor.getPosicao() == posicao);
	}

}