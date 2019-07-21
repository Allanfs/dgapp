package com.github.allanfs.dgapp.dgapp.pedido.service;

import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

import org.springframework.stereotype.Service;

@Service
public interface ProdutoService extends IService<Produto> {

	public boolean ehDaCategoria(Produto produto, String categoria);
	
}
