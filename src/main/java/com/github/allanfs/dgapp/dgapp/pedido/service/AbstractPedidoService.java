package com.github.allanfs.dgapp.dgapp.pedido.service;

import static org.springframework.util.StringUtils.isEmpty;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

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
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.PedidoSemItensException;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

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
	
	public List<Pedido> buscarPorEstado(Estado estado) {
		return repo.findByEstado(estado);
	}
	
	public List<Pedido> buscarPedidoPorCliente(UUID id) {
		return repo.findByCliente(id);
	}

	private boolean estadoEhAberto(Pedido pedido) {
		return pedido.getEstado().estaAberto();
	}

	private boolean estadoEhCancelado(Pedido pedido) {
		return pedido.getEstado().estaCancelado();
	}
	
	private boolean estadoEhFechado(Pedido pedido) {
		return this.pedido.getEstado().estaFechado();
	}
	
	public void adicionarEndereco(Pedido pedido, Endereco endereco) {
		pedido.setEndereco(endereco);
	}
	
	public void adicionarCliente(Pedido pedido, Cliente cliente) {
		pedido.setCliente(cliente);
	}

	public boolean validarItens(Pedido pedido) {

		/*
		 * 1) verifica se existem itens no pedido
		 */
		if (pedido.getItens() == null || pedido.getItens().size() <= 0) {
			IService.logger.info("Pedido não possui itens.");
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}

		
		IService.logger.info( String.format("Pedido com [%d] itens", pedido.getItens().size()) );
		/*
		 * 2) verificar se a quantidade de itens presente no pedido é valida;
		 * 3) verificar se o item possui referencia a este pedido.
		 * parallelStream evita ConcurrentModificationException
		 * 4) Verifica se o item é pizza,
		 * se for, valida os sabores do Item.
		 * se não, ignora, settando-os com null
		 */
		pedido.getItens().parallelStream().forEach( item -> {
			if (!item.quantidadeMaiorQueZero()) {
				pedido.getItens().remove(item);
				return;
			}
			
			if (item.getPedido() == null) {
				item.setPedido(pedido);
			}
			if (!pizzaValida(item)) {
				/*
				 * 4.1) despreza campos pertinentes a pizza
				 */
				item.setTamanho(null);
				item.setSabores(null);
				IService.logger.info("Item não é uma pizza!");
			}
			
		});
		
		/*
		 * 5) verifica a quantidade de itens novamente. 
		 * Se, após a validação não houver pelo menos  um item
		 * uma exceção é lançada
		 */
		if (this.obterQuantidadeDeItens(pedido) <= 0) {
			IService.logger.info("Após validação dos itens, não há nenhum item no pedido.");
			throw new PedidoSemItensException(message.getMessage("pedido.sem.itens", null, Locale.ROOT));
		}
		IService.logger.info("Validação de itens do pedido. OK");
		return true;

	}

	private void validarPizza(ItemPedido pizza) {
		
		int quantidadeDeSaboresNaPizza;
		int numeroMaximoDeSaboresNoTamanho;
		
		
		if (pizza.getTamanho() == null) {
			IService.logger.info("Tamanho da pizza não foi informado");
			throw new PedidoException("Tamanho da pizza não informado.");
		} else if (pizza.getSabores() == null || pizza.getSabores().isEmpty()) {
			IService.logger.info("Sabores da pizza não foram informados");
			throw new PedidoException("Sabores da pizza não foram informados.");
		}
		
		quantidadeDeSaboresNaPizza = pizza.getSabores().size();
		numeroMaximoDeSaboresNoTamanho = pizza.getTamanho().getNumeroMaximoSabores();
		
		if(quantidadeDeSaboresNaPizza > numeroMaximoDeSaboresNoTamanho) {
			String msg = String.format("Quantidade de sabores maior que a permitida para o tamanho. %d foram informados, o máximo é %d", quantidadeDeSaboresNaPizza, numeroMaximoDeSaboresNoTamanho);
			IService.logger.info(msg);
			throw new PedidoException(msg);
		}
		
	}
	
	private boolean pizzaValida(ItemPedido pizza) {
		
		int quantidadeDeSaboresNaPizza;
		int numeroMaximoDeSaboresNoTamanho;
		IService.logger.info("Item null, " + (pizza== null));
		// o produto do item é null ou não é pizza?
		if (pizza.getProduto() == null || !pizza.getProduto().isPizza()) {
			IService.logger.info("Produto da pizza é null ou não é pizza");
			return false;
		}
		
		if (pizza.getTamanho() == null) {	// o tamanho foi informado?
			
			IService.logger.info("Tamanho da pizza não foi informado");
			throw new PedidoException("Tamanho da pizza não informado.");
			
		} else if (pizza.getSabores() == null || pizza.getSabores().isEmpty()) {	// os sabores são validos?
			
			IService.logger.info("Sabores da pizza não foram informados");
			throw new PedidoException("Sabores da pizza não foram informados.");
			
		}
		IService.logger.info("Item é uma pizza. Possui tamanho e sabores validos");
		quantidadeDeSaboresNaPizza = pizza.getSabores().size();
		numeroMaximoDeSaboresNoTamanho = pizza.getTamanho().getNumeroMaximoSabores();
		
		// a pizza tem mais sabores do que o tamanho permite?		
		if(quantidadeDeSaboresNaPizza > numeroMaximoDeSaboresNoTamanho) {
			
			String msg = String.format("Quantidade de sabores maior que a permitida para o tamanho. %d foram informados, o máximo é %d", quantidadeDeSaboresNaPizza, numeroMaximoDeSaboresNoTamanho);
			IService.logger.info(msg);
			throw new PedidoException(msg);
			
		}
		
		// associa o itemPedido aos sabores
		pizza.getSabores().stream()
			.filter(sabor -> sabor.getItemPedido() == null)
			.forEach(sabor -> {
				IService.logger.info("Sabor com item pedido null " + (sabor.getItemPedido() == null));
				sabor.setItemPedido(pizza);
			});
		return true;
	}
	
	public int obterQuantidadeDeItensUnicos(Pedido pedido) {

		return pedido.getItens().size();

	}
	
	public int obterQuantidadeDeItens(Pedido pedido) {
		int quantidadeTotal = 0;
		for (ItemPedido item : pedido.getItens()) {
			quantidadeTotal = item.getQuantidade();
		}
		return quantidadeTotal;
	}

	public void adicionarItem(Pedido pedido, Produto produto) {
	}
	
	public void adicionarItem(Produto produto, int qtdAdicionar) {
	}

	public void removerUmItem(Pedido pedido, Produto produto) {
	}

	public void removerItem(Pedido pedido, Produto produto) {
	}

	public void adicionarDesconto(Pedido pedido, Operacao desconto) {
		if (desconto.ehDesconto()) {
		}
	}

	public void adicionarCobranca(Pedido pedido, Operacao cobranca) {
		if (cobranca.ehCobranca()) {
		}
	}

	public void adidiconarOperacao(Pedido pedido, Operacao operacao) {
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

	public BigDecimal calcularSubtotal(Pedido pedido) {
		System.err.println("Implementar calculo de subtotal.");
		BigDecimal subtotal = new BigDecimal(0);

		return subtotal;
	}

	public BigDecimal calcularTotal(Pedido pedido) {
		BigDecimal subtotal = calcularSubtotal(pedido);

		return subtotal.add(subtotal);
	}

	public void fecharPedido(Pedido pedido) {
		if (estadoEhAberto(pedido)) {
			// forma de pagamento
			if(pedido.getPagamento() != null){
				
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
			pedido.setHoraFechamento(Calendar.getInstance().getTime());
			pedido.setEstado(Estado.FECHADO);
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
	
	public Integer contarPedidosNoEstado(Estado estado) {
		return repo.countByEstado(estado);
	}
	
}
