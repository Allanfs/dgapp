package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dentro de uma classe sabor, os 
 * @author allan
 *
 */
@Entity
@Table(name = "tb_sabor_ordem_recheio")
@NoArgsConstructor @AllArgsConstructor
public class SaborOrdemRecheio {

	@EmbeddedId
	@JsonIgnore
	@Getter private SaborOrdemRecheioEmbeddedId id;
	@Getter @Setter private Integer posicao;
	
	public SaborOrdemRecheio(Sabor saborNovo, Recheio recheio, int i) {
		this(recheio, i);
		setSabor(saborNovo);
	}
	
	public SaborOrdemRecheio(Recheio recheio, Integer i) {
		setRecheio(recheio);
		setPosicao(i);
	}
	
	public Recheio getRecheio() {
		return id.getRecheio();
	}
	
	@JsonBackReference
	public Sabor getSabor() {
		return id.getSabor();
	}
	
	public void setRecheio( Recheio recheio ) {
		if( id == null ) {
			id = new SaborOrdemRecheioEmbeddedId();
		}
		id.setRecheio(recheio);
	}
	
	public void setSabor( Sabor sabor ) {
		if( id == null ) {
			id = new SaborOrdemRecheioEmbeddedId();
		}
		id.setSabor(sabor);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + posicao;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaborOrdemRecheio other = (SaborOrdemRecheio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (posicao != other.posicao)
			return false;
		return true;
	}
}
