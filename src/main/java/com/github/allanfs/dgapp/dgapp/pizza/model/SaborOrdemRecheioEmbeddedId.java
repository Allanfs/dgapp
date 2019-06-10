package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dentro de uma classe sabor, os recheios 
 * possuem posições especificas.
 * 
 * Ex.: Molho e mussarela são os primeiros
 * recheios em muitos sabores
 * @author allan
 *
 */

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(value = "sabor")
public class SaborOrdemRecheioEmbeddedId implements Serializable{

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="ID_SABOR_FK", referencedColumnName="id_sabor")
	@Getter @Setter private Sabor sabor;
	
	@ManyToOne()
	@JoinColumn(name="ID_RECHEIO_FK", referencedColumnName="id_recheio")
	@Getter @Setter private Recheio recheio;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recheio == null) ? 0 : recheio.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
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
		SaborOrdemRecheioEmbeddedId other = (SaborOrdemRecheioEmbeddedId) obj;
		if (recheio == null) {
			if (other.recheio != null)
				return false;
		} else if (!recheio.equals(other.recheio))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		return true;
	}
	
}
