package com.github.allanfs.dgapp.dgapp.pedido.service;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Numerario {
	@Getter @Setter
	private float valor;
	
	public boolean maiorQue(Numerario valor) {
		return this.valor > valor.getValor();
	}
	
	public boolean menorQue(Numerario valor) {
		return this.valor < valor.getValor();
	}
	
	public void adicionar(Numerario valor) {
		this.valor += valor.getValor();
	}
	public void subtrair(Numerario valor) {
		this.valor -= valor.getValor();
	}
	public Numerario menos(Numerario valor) {
		return new Numerario(this.valor - valor.getValor());
	}
	public Numerario mais(Numerario valor) {
		return new Numerario(this.valor + valor.getValor());
	}
	public Numerario vezes(Numerario valor) {
		return new Numerario(this.valor * valor.getValor());
	}
	public Numerario divididoPor(Numerario valor) {
		return new Numerario(this.valor / valor.getValor());
	}
}
