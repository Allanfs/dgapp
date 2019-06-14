package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Set;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

public class Pizza extends Produto {

	private Set<Sabor> sabores;
	private Tamanho tamanho;
}
