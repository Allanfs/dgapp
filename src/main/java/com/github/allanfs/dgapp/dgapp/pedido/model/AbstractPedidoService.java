package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractPedidoService {

	@Getter
	@Setter
	protected Pedido pedido;

	@Autowired
	protected MessageSource message;

	public void adicionarEndereco(Endereco endereco) {
		this.pedido.setEndereco(endereco);
	}

	public void adicionarCliente(Cliente cliente) {
		this.pedido.setCliente(cliente);
	}

	public boolean validarItens() {

		if (this.pedido.getItens() == null || this.pedido.getItens().size() <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		Predicate<? super Entry<Produto, Integer>> itensMenoresQueZero = entry -> entry.getValue() <= 0;

		Set<Entry<Produto, Integer>> entrySetItens = this.pedido.getItens().entrySet();

		entrySetItens.removeIf(itensMenoresQueZero);

		if (this.obterQuantidadeDeItens() <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		return true;

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
		} else {
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

	public BigDecimal calcularSubtotal() {
		Map<Produto, Integer> itens = this.pedido.getItens();

		BigDecimal subtotal = new BigDecimal(0);
		;

		for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
			Produto produto = entry.getKey();
			BigDecimal quantidade = new BigDecimal(entry.getValue());

			subtotal = subtotal.add(produto.getValor().multiply(quantidade));

		}

		return subtotal;
	}

	public BigDecimal calcularTotal() {
		BigDecimal subtotal = calcularSubtotal();
		BigDecimal valorDeOperacao = new BigDecimal(0);

		for (Operacao operacao : this.pedido.getOperacoes()) {
			valorDeOperacao = valorDeOperacao.add(operacao.getValor());
		}

		return subtotal.add(valorDeOperacao);
	}

	public void fecharPedido() {
		this.pedido.setHoraFechamento(Calendar.getInstance().getTime());
	}

}
