package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.Expediente;
import com.github.allanfs.dgapp.dgapp.pedido.service.Numerario;

public class PedidoNovo {
	
	UUID id;
	
	String numeroPedido;
	
	Date horaAbertura;
	Date horaFechamento;
	
	Cliente cliente;
	Endereco endereco;
	
	Map<Produto, Integer> itens;
	
	List<Operacao> operacoes;
	
	Numerario total;
	Numerario valorPago;
	
	Expediente expediente;
	Pedido pedido;
	public void adicionarEndereco(Endereco endereco) {
		this.pedido.setEndereco(endereco);
	}
	public void adicionarCliente(Cliente cliente) {
		this.pedido.setCliente(cliente);
	}
	public void adicionarItem(Produto produto) {
		Map<Produto, Integer> itens = this.pedido.getItens();
		if (itens.containsKey(produto)) {
			int quantidade = itens.get(produto);
			itens.put(produto, quantidade);
		}else {
			itens.put(produto, 1);
		}
	}
	public void removerUmItem(Produto produto) {
		Map<Produto, Integer> itens = this.pedido.getItens();
		
		if (itens.containsKey(produto)) {
			int quantidade = itens.get(produto);
			itens.put(produto, --quantidade);
		}
	}
	public void removerItem(Produto produto) {
		Map<Produto, Integer> itens = this.pedido.getItens();
		
		if (itens.containsKey(produto)) {
			itens.remove(produto);
		}
	}
	
	public Numerario calcularSubtotal() {
		Map<Produto, Integer> itens = this.pedido.getItens();
		
		Numerario subtotal = new Numerario();
		
		for (Map.Entry<Produto, Integer> entry: itens.entrySet()) {
			Produto produto = entry.getKey();
			Integer quantidade = entry.getValue();
			
			subtotal.adicionar( new Numerario(produto.getValor().getValor() * quantidade) );
			
		}
		
		return subtotal;
	}
	
	public Numerario calcularTotal() {
		Numerario subtotal = calcularSubtotal();
		float valorDeOperacao = 0; 
		
		for (Operacao operacao : operacoes) {
			valorDeOperacao += operacao.getValor();
		}
		
		return new Numerario(valorDeOperacao);
	}
}