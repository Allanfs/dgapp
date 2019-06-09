package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue(generator = "UUID")
	@Column(name="id_sabor")
	@Getter	@Setter	UUID id;
	@Getter @Setter private String nome;
	
	@OneToMany(  cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
	@JsonManagedReference
	@Getter @Setter private Set<SaborOrdemRecheio> recheios = new HashSet<SaborOrdemRecheio>();
	
	@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	@Getter @Setter private Set<SaborPrecoTamanho> precosTamanhos;
	
	public void adicionarRecheio(Recheio recheio, int posicao) {
		recheios.add( new SaborOrdemRecheio(recheio, posicao));
	}
	
	public void removerRecheioNaPosicao(int posicao) {
		recheios.removeIf( sor -> sor.getPosicao() == posicao);
	}
	
}
