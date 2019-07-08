package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.function.Predicate;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.ItemPedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Operacao;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractPedidoService {

	@Getter
	@Setter
	protected Pedido pedido;

	@Autowired
	protected MessageSource message;

	private boolean estadoEhAberto() {
		return this.pedido.getEstado().estaAberto();
	}

	private boolean estadoEhCancelado() {
		return this.pedido.getEstado().estaCancelado();
	}

	private boolean estadoEhFechado() {
		return this.pedido.getEstado().estaFechado();
	}

	public void adicionarEndereco(Endereco endereco) {
		this.pedido.setEndereco(endereco);
	}

	public void adicionarCliente(Cliente cliente) {
		this.pedido.setCliente(cliente);
	}

	public boolean validarItens() {

		/*
		 * 1) verifica se existem itens no pedido
		 */
		if (this.pedido.getItens() == null || this.pedido.getItens().size() <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		Predicate<? super Entry<Produto, Integer>> itensMenoresQueZero = entry -> entry.getValue() <= 0;

		/*
		 * 2) verificar se a quantidade de itens presente no pedido é valida 3)
		 * verificar se o item possui referencia a este pedido.
		 * parallelStream evita ConcurrentModificationException
		 */
		this.pedido.getItens().parallelStream().forEach(item -> {
			if (item.getQuantidade() <= 0) {
				this.pedido.getItens().remove(item);
				return;
			}
			if (item.getPedido() == null) {
				item.setPedido(this.pedido);
			}

		});

		/*
		 * 3) verifica a quantidade de itens novamente. 
		 * Se, após a validação não houver pelo menos  um item
		 * uma exceção é lançada
		 */
		if (this.obterQuantidadeDeItens() <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		return true;

	}

	public int obterQuantidadeDeItensUnicos() {

		return this.pedido.getItens().size();

	}

	public int obterQuantidadeDeItens() {
		int quantidadeTotal = 0;
		for (ItemPedido item : this.pedido.getItens()) {
			quantidadeTotal = item.getQuantidade();
		}
		return quantidadeTotal;
	}

	public void adicionarItem(Produto produto) {
	}
	
	public void adicionarItem(Produto produto, int qtdAdicionar) {
	}

	public void removerUmItem(Produto produto) {
	}

	public void removerItem(Produto produto) {
	}

	public void adicionarDesconto(Operacao desconto) {
		if (desconto.ehDesconto()) {
		}
	}

	public void adicionarCobranca(Operacao cobranca) {
		if (cobranca.ehCobranca()) {
		}
	}

	public void adidiconarOperacao(Operacao operacao) {
	}

	public BigDecimal calcularSubtotal() {
		System.err.println("Implementar calculo de subtotal.");
		BigDecimal subtotal = new BigDecimal(0);

		return subtotal;
	}

	public BigDecimal calcularTotal() {
		BigDecimal subtotal = calcularSubtotal();

		return subtotal.add(subtotal);
	}

	public void fecharPedido() {
		if (estadoEhAberto()) {
			this.pedido.setHoraFechamento(Calendar.getInstance().getTime());
			this.pedido.setEstado(Estado.FECHADO);
		}
	}

	public Pedido cancelarPedido() {
		if (estadoEhAberto()) {
			this.pedido.setHoraFechamento(Calendar.getInstance().getTime());
			this.pedido.setEstado(Estado.CANCELADO);
			
			return this.pedido;
		}
		return null;
	}
	
}
