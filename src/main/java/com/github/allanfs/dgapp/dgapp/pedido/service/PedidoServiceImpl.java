package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PedidoServiceImpl extends AbstractPedidoService implements PedidoService {

	@Autowired
	private PedidoRepository service;
	
	public PedidoServiceImpl(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido cadastrar() {
		return null;
	}
	
	@Override
	public Pedido cadastrar(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido editar(Pedido obj) throws EntityNotFoundException {
		return null;
	}

	@Override
	public List<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}
	
}
