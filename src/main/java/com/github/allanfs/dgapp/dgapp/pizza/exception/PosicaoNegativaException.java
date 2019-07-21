package com.github.allanfs.dgapp.dgapp.pizza.exception;

/**
 * Quando a posição de um recheio em um sabor for menor que zero
 * esta exceção é usada.
 * @author allan
 *
 */
public class PosicaoNegativaException extends RuntimeException {

	public PosicaoNegativaException (String mensagem) {
		super(mensagem);
	}
	
}
