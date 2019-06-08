package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	// cada subclasse deve possuir este atributos em suas colunas
public abstract class TipoInsumo {
	
	@Getter	@Setter	private boolean ehSalgado;
	@Getter	@Setter	private boolean ehEspecial;
	@Getter	@Setter	private boolean ehDisponivel;
}
