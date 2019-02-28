package com.github.allanfs.dgapp.modelo;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractElemento {

	/**
	 * Código de identificação de um Elemento para distinguir-se de ID
	 */
	@Getter @Setter private String codigo;
	
	/**
	 * Informa se o Elemento pode ser usado por outras classes
	 */
	@Getter @Setter private boolean disponivel;
	
}
