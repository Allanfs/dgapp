package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dentro de uma classe sabor, os 
 * @author allan
 *
 */
@Entity(name = "tb_sabor_ordem_recheio")
@NoArgsConstructor @AllArgsConstructor
@Data
public class SaborOrdemRecheio {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_sor")
	private UUID id;
	
	@Embedded
	@JsonIgnore
	private SaborOrdemRecheioEmbeddedId sor;
	private Integer posicao;
	
	public SaborOrdemRecheio(Sabor saborNovo, Recheio recheio, int i) {
		this(recheio, i);
		setSabor(saborNovo);
	}
	
	public SaborOrdemRecheio(Recheio recheio, Integer i) {
		setRecheio(recheio);
		setPosicao(i);
	}
	
	public Recheio getRecheio() {
		return sor.getRecheio();
	}
	
	@JsonBackReference
	public Sabor getSabor() {
		return sor.getSabor();
	}
	
	public void setRecheio( Recheio recheio ) {
		if( sor == null ) {
			sor = new SaborOrdemRecheioEmbeddedId();
		}
		sor.setRecheio(recheio);
	}
	
	public void setSabor( Sabor sabor ) {
		if( sor == null ) {
			sor = new SaborOrdemRecheioEmbeddedId();
		}
		sor.setSabor(sabor);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sor == null) ? 0 : sor.hashCode());
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
		if (sor == null) {
			if (other.sor != null)
				return false;
		} else if (!sor.equals(other.sor))
			return false;
		if (posicao != other.posicao)
			return false;
		return true;
	}
}
