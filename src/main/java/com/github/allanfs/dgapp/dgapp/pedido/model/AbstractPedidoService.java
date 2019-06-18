package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ProibidoAlterarPedidoNoEstadoException;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractPedidoService {
	@Getter
	@Setter
	public Pedido pedido;
	
	public String gerarNumeroPedido() {
		Calendar ca = Calendar.getInstance();

		String padraoData = "ddMMyyHHmm";

		SimpleDateFormat format = new SimpleDateFormat(padraoData);
		String strDataFormatada = format.format(ca.getTime());

		StringBuilder sb = new StringBuilder(strDataFormatada);

		strDataFormatada += "001";

		System.out.println(String.format("%-13s", strDataFormatada));
		
		return strDataFormatada;
	}

	public Estado getEstadoPedido() {
		return pedido.getEstado();
	}
	
	public void setEstadoAberto() {
		pedido.setEstado(Estado.ABERTO);
	}
	
	public void setEstadoFechado() {
		pedido.setEstado(Estado.FECHADO);
	}
	
	/**
	 * @param endereco que será entregue o pedido
	 * @param forcar - insere o endereco mesmo que o cliente não possua o endereço informado
	 * @throws ProibidoAlterarPedidoNoEstadoException caso pedido esteja {@link Estado#FECHADO} ou {@link Estado#CANCELADO}
	 */
	public void inserirEndereco(Endereco endereco, boolean forcar) throws ProibidoAlterarPedidoNoEstadoException {
		
		Estado estadoDoPedido = this.pedido.getEstado();
		if (estadoDoPedido.estaAberto()) {
			
			Cliente clienteDoPedido = pedido.getCliente();
			
			boolean enderecoEhDoCliente = endereco.getCliente().equals(clienteDoPedido);
			boolean clientePossiuEndereco = clienteDoPedido.getEndereco().contains(endereco);
			
			if (enderecoEhDoCliente && clientePossiuEndereco) {
				pedido.setEndereco(endereco);
			} else {
				if (forcar) {
					pedido.setEndereco(endereco);
					return;
				}
			}
			System.err.println("O Cliente não possui o endereco, nem o endereço é do cliente informado");
				
		}else {
			
			throw new ProibidoAlterarPedidoNoEstadoException(pedido.getEstado());
			
		}
		
	}
	
	public void inserirCliente(Cliente cliente) throws ProibidoAlterarPedidoNoEstadoException {
		if (this.pedido.getEstado().estaAberto()) {
			pedido.setCliente(cliente);
		}else {
			throw new ProibidoAlterarPedidoNoEstadoException(pedido.getEstado());
		}
	}
	
	public Pedido fecharPedido() throws ProibidoAlterarPedidoNoEstadoException {
		switch (getEstadoPedido()) {
		case ABERTO:
			System.err.println("Ao fechar pedido deve ser verificado os pagamentos");
			this.pedido.setEstado(Estado.FECHADO);
			return this.pedido;

		default:
			throw new ProibidoAlterarPedidoNoEstadoException(pedido.getEstado());
		}
	}
	
	public Pedido cancelarPedido() throws ProibidoAlterarPedidoNoEstadoException {
		
		switch (pedido.getEstado()) {
		case ABERTO:
			pedido.setEstado(Estado.CANCELADO);
			return this.pedido;
			
		default:
			throw new ProibidoAlterarPedidoNoEstadoException(pedido.getEstado());
		}
		
	}
}
