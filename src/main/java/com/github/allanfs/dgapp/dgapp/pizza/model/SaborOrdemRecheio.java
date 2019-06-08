package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	@Getter @Setter private SaborOrdemRecheioEmbeddedId id;
	@Getter @Setter private int posicao;
	
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
