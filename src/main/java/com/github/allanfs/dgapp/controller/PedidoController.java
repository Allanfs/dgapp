package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Pedido;

@RestController
public class PedidoController implements IController<Pedido> {

	@Override
	public Pedido cadastrar(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido editar(Pedido obj, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}
}