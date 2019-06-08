package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	// cada subclasse deve possuir este atributos em suas colunas
public abstract class TipoInsumo {
	
	@Getter	@Setter	protected boolean ehSalgado;
	@Getter	@Setter	protected boolean ehEspecial;
	@Getter	@Setter	protected boolean ehDisponivel;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ehDisponivel ? 1231 : 1237);
		result = prime * result + (ehEspecial ? 1231 : 1237);
		result = prime * result + (ehSalgado ? 1231 : 1237);
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
		TipoInsumo other = (TipoInsumo) obj;
		if (ehDisponivel != other.ehDisponivel)
			return false;
		if (ehEspecial != other.ehEspecial)
			return false;
		if (ehSalgado != other.ehSalgado)
			return false;
		return true;
	}
	
	
	
}
