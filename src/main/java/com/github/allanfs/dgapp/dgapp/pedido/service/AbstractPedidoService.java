package com.github.allanfs.dgapp.dgapp.pedido.service;

import static org.springframework.util.StringUtils.isEmpty;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.FormaDePagamento;
import com.github.allanfs.dgapp.dgapp.pedido.model.ItemPedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Operacao;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.CancelamentoDePedidoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.FechamentoDePedidoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractPedidoService {

	@Getter
	@Setter
	protected Pedido pedido;

	@Autowired
	protected PedidoRepository repo;

	@Autowired
	protected MessageSource message;

	@Deprecated
	private boolean estadoEhAberto() {
		return this.pedido.getEstado().estaAberto();
	}
	
	private boolean estadoEhAberto(Pedido pedido) {
		return pedido.getEstado().estaAberto();
	}

	@Deprecated
	private boolean estadoEhCancelado() {
		return this.pedido.getEstado().estaCancelado();
	}

	private boolean estadoEhCancelado(Pedido pedido) {
		return pedido.getEstado().estaCancelado();
	}
	
	@Deprecated
	private boolean estadoEhFechado() {
		return this.pedido.getEstado().estaFechado();
	}
	
	private boolean estadoEhFechado(Pedido pedido) {
		return this.pedido.getEstado().estaFechado();
	}
	
	@Deprecated
	public void adicionarEndereco(Endereco endereco) {
		this.pedido.setEndereco(endereco);
	}
	
	public void adicionarEndereco(Pedido pedido, Endereco endereco) {
		pedido.setEndereco(endereco);
	}

	@Deprecated
	public void adicionarCliente(Cliente cliente) {
		this.pedido.setCliente(cliente);
	}
	
	public void adicionarCliente(Pedido pedido, Cliente cliente) {
		pedido.setCliente(cliente);
	}

	public boolean validarItens(Pedido pedido) {

		/*
		 * 1) verifica se existem itens no pedido
		 */
		if (pedido.getItens() == null || pedido.getItens().size() <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		Predicate<? super Entry<Produto, Integer>> itensMenoresQueZero = entry -> entry.getValue() <= 0;

		/*
		 * 2) verificar se a quantidade de itens presente no pedido é valida 3)
		 * verificar se o item possui referencia a este pedido.
		 * parallelStream evita ConcurrentModificationException
		 */
		pedido.getItens().parallelStream().forEach(item -> {
			if (item.getQuantidade() <= 0) {
				pedido.getItens().remove(item);
				return;
			}
			if (item.getPedido() == null) {
				item.setPedido(pedido);
			}

		});

		/*
		 * 3) verifica a quantidade de itens novamente. 
		 * Se, após a validação não houver pelo menos  um item
		 * uma exceção é lançada
		 */
		if (this.obterQuantidadeDeItens(pedido) <= 0) {
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		return true;

	}

	@Deprecated
	public int obterQuantidadeDeItensUnicos() {

		return this.pedido.getItens().size();

	}
	
	public int obterQuantidadeDeItensUnicos(Pedido pedido) {

		return pedido.getItens().size();

	}

	@Deprecated
	public int obterQuantidadeDeItens() {
		int quantidadeTotal = 0;
		for (ItemPedido item : this.pedido.getItens()) {
			quantidadeTotal = item.getQuantidade();
		}
		return quantidadeTotal;
	}
	
	public int obterQuantidadeDeItens(Pedido pedido) {
		int quantidadeTotal = 0;
		for (ItemPedido item : pedido.getItens()) {
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

	/**
	 * Caso o pedido já tenha um pagamento informado irá sobrescreve-lo
	 * @param pedido {@link Pedido} já cadastrado que será adicionado o pagamento.
	 * @param pagamento {@link com.github.allanfs.dgapp.dgapp.pedido.model.Pagamento Pagamento}
	 */
	public void adicionarPagamento(Pedido pedido, FormaDePagamento pagamento) {
		if (pagamento != null) {
			pedido.setPagamento(pagamento);
		}
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

	public void fecharPedido(Pedido pedido) {
		if (estadoEhAberto(pedido)) {
			// forma de pagamento
			if(this.pedido.getPagamento() != null){
				switch (this.pedido.getPagamento().getValorPago().compareTo(this.pedido.getTotal())) {
				case 0: // valor exato

					break;
				case -1: // pagamento é menor que o valor total -> não fecha

					break;
				case 1: // pagamento é maior que o valor total -> informa troco

					break;

				default:
					break;
				}
			}else{
				throw new FechamentoDePedidoException("Pagamento não informado");
			}
			this.pedido.setHoraFechamento(Calendar.getInstance().getTime());
			this.pedido.setEstado(Estado.FECHADO);
		} else if (estadoEhCancelado(pedido)) {
			throw new FechamentoDePedidoException("Pedido no estado cancelado");
		} else if (estadoEhFechado(pedido)) {
			throw new FechamentoDePedidoException("Pedido no estado cancelado");

		}
	}

	public Pedido cancelarPedido(Pedido pedido) {
		if (estadoEhAberto(pedido)) {
			if (isEmpty(pedido.getMotivoCancelamento())) {
				throw new CancelamentoDePedidoException("Motivo do cancelamento não informado");
			}
			pedido.setHoraFechamento(Calendar.getInstance().getTime());
			pedido.setEstado(Estado.CANCELADO);

			return repo.save(pedido);
		}else{
			throw new CancelamentoDePedidoException("Apenas pedidos no estado ABERTO podem ser cancelados.");
		}
		
	}
	
}
