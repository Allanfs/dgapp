package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.Numerario;

import lombok.Getter;
import lombok.Setter;

public class PedidoNovoService {
	
	@Getter @Setter
	private PedidoNovo pedido;

	public void adicionarEndereco(Endereco endereco) {
		this.pedido.setEndereco(endereco);
	}
	public void adicionarCliente(Cliente cliente) {
		this.pedido.setCliente(cliente);
	}
	
	public int obterQuantidadeDeItensUnicos() {
		
		return this.pedido.getItens().size();
		
	}
	
	public int obterQuantidadeDeItens() {
		Set<Entry<Produto, Integer>> entrySet = this.pedido.getItens().entrySet();
		int quantidade = 0;
		for (Entry<Produto, Integer> entry : entrySet) {
			quantidade += entry.getValue();
		}
		
		return quantidade;
	}
	
	public void adicionarItem(Produto produto) {
		Map<Produto, Integer> itens = this.pedido.getItens();
		if (itens.containsKey(produto)) {
			int quantidade = itens.get(produto);
			itens.put(produto, ++quantidade);
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
	
	public void adicionarDesconto(Operacao desconto) {
		if (desconto.ehDesconto()) {
			this.pedido.getOperacoes().add(desconto);
		}
	}
	public void adicionarCobranca(Operacao cobranca) {
		if (cobranca.ehCobranca()) {
			this.pedido.getOperacoes().add(cobranca);
		}
	}
	
	public void adidiconarOperacao(Operacao operacao) {
		this.pedido.getOperacoes().add(operacao);
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
		
		for (Operacao operacao : this.pedido.getOperacoes()) {
			valorDeOperacao += operacao.getValor();
			/*if (operacao.ehDesconto()) {
				valorDeOperacao -= operacao.getValor();
				
			}else {
				valorDeOperacao += operacao.getValor();
			}*/
		}
		
		return subtotal.mais(new Numerario(valorDeOperacao));
	}
	
	public void fecharPedido() {
		this.pedido.setHoraFechamento( Calendar.getInstance().getTime() );
	}
	
}
