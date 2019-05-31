package com.github.allanfs.dgapp.modelo.pizza;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor @NoArgsConstructor
public class SaborPrecoEmbeddedId implements Serializable {
	
    @ManyToOne
    @JoinColumn(name="ID_SABOR_FK", referencedColumnName="id_sabor")
	@Getter @Setter private Sabor sabor;
	
    @ManyToOne
    @JoinColumn(name="ID_TAMANHO_FK", referencedColumnName="id_tamanho")
	@Getter @Setter private Tamanho tamanho;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
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
		SaborPrecoEmbeddedId other = (SaborPrecoEmbeddedId) obj;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		return true;
	}
    
    
}
