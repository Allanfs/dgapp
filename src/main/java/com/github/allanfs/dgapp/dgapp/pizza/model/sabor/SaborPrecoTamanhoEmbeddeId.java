package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "sabor")
class SaborPrecoTamanhoEmbeddeId implements Serializable {

	@Getter
	@Setter
	@ManyToOne()
	@JoinColumn(
			name = "ID_SABOR_PRECO_TAMANHO", 
			referencedColumnName = "id_sabor", 
			foreignKey = @ForeignKey(
					name = "id_sabor_fk_esta_para_id_sabor"))
	private Sabor sabor;

	@Getter
	@Setter
	@ManyToOne()
	@JoinColumn(
			name = "ID_TAMANHO_PRECO_TAMANHO", 
			referencedColumnName = "id_tamanho", 
			foreignKey = @ForeignKey(
					name = "id_tamnho_fk_esta_para_id_tamanho"))
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