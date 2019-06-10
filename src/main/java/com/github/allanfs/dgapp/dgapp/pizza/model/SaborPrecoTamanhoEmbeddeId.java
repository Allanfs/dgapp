package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
class SaborPrecoTamanhoEmbeddeId implements Serializable {

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_SABOR_FK", referencedColumnName = "id_sabor")
	@Getter
	@Setter
	private Sabor sabor;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_TAMANHO_FK", referencedColumnName = "id_tamanho")
	@Getter
	@Setter
	private Tamanho tamanho;

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
		SaborPrecoTamanhoEmbeddeId other = (SaborPrecoTamanhoEmbeddeId) obj;
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
