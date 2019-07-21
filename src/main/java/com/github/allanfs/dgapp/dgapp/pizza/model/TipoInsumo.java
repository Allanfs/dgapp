package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	// cada subclasse deve possuir este atributos em suas colunas
@Data
public abstract class TipoInsumo {
	
	protected boolean ehSalgado;
	protected boolean ehEspecial;
	protected boolean ehDisponivel;
	
}
