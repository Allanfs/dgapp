package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "tb_tamanho")
@NoArgsConstructor 
public class Tamanho {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_tamanho")
	@Getter	@Setter	UUID id;
	@Getter @Setter private String nome;
	@Getter @Setter private int numeroFatias;
	@Getter @Setter private int numeroMaximoSabores;
	@Getter @Setter private int centimetros;
	@Getter @Setter private float precoPadrao;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + centimetros;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroFatias;
		result = prime * result + numeroMaximoSabores;
		result = prime * result + Float.floatToIntBits(precoPadrao);
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
		Tamanho other = (Tamanho) obj;
		if (centimetros != other.centimetros)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroFatias != other.numeroFatias)
			return false;
		if (numeroMaximoSabores != other.numeroMaximoSabores)
			return false;
		if (Float.floatToIntBits(precoPadrao) != Float.floatToIntBits(other.precoPadrao))
			return false;
		return true;
	}
	
}
