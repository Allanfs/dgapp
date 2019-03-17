package com.github.allanfs.dgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.modelo.Pedido;
import com.github.allanfs.dgapp.service.PedidoService;

@RestController
public class PedidoController implements IController<Pedido> {

	private static final String SERVICO = "/pedido";
	
	@Autowired
	private PedidoService PedidoServ;
	
	@Override
	@PostMapping(SERVICO)
	public Pedido cadastrar(Pedido obj) {
		return PedidoServ.cadastrar(obj);
	}

	@Override
	@GetMapping(value=SERVICO)
	public List<Pedido> buscarTodos() {
		return PedidoServ.buscarTodos();
	}

	@Override
	@GetMapping(value=SERVICO + "/{id}")
	public Pedido buscarPorId(Long id) {
		return PedidoServ.buscarPorId(id);
	}

	@Override
	@PutMapping(SERVICO + "/{id}")
	public Pedido editar(Pedido obj, Long id) {
		return PedidoServ.editar(obj);
	}

	@Override
	@DeleteMapping(SERVICO + "/{id}")
	public void deletar(Long id) {
		PedidoServ.deletar(id);
		
	}
}