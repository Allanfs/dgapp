package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.service.PedidoService;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;

/**
 * PedidoController
 */
@RestController
@RequestMapping(name = "PedidoController", path = "/pedidos")
public class PedidoController extends AbstractController<Pedido> {
	
	@Autowired
	protected PedidoService service;

	@PatchMapping("/{id}/fechar")
	public ResponseEntity<Pedido> fecharPedido(@PathVariable UUID id){
		
		service.fecharPedido( service.buscarPorId(id) );
		
		return new ResponseEntity<Pedido>(HttpStatus.OK); 
	}
	
	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Pedido>> obterPedidoNoStatus(@PathVariable Estado estado) {
		List<Pedido> pedidos = service.buscarPorEstado(estado);
		if (pedidos.isEmpty()) {
			return new ResponseEntity<List<Pedido>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
		}

	}
	
	@ExceptionHandler({ ClienteNaoInformadoException.class, EnderecoNaoInformadoException.class })
	public ResponseEntity<String> componenteNaoInformado(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}