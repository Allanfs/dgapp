package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Operacao;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

public interface PedidoService extends IService<Pedido> {

	public void adicionarEndereco(Endereco endereco);

	public void adicionarCliente(Cliente cliente);

	/**
	 * Obtem a quantidade de pedidos únicos no pedido,
	 * sem calcular a quantidade de cada um.
	 */
	public int obterQuantidadeDeItensUnicos();

	public int obterQuantidadeDeItens();

	/**
	 * Insere o produto ao pedido. Caso o produto já 
	 * exista no pedido sua quantidade será incrementada.
	 * @param produto
	 */
	public void adicionarItem(Produto produto);

	/**
	 * Remove uma unidade de um produto no pedido.
	 * Se após a remoção a quantidade do produto for zero,
	 * o produto será removido do pedido.
	 * @param produto
	 */
	public void removerUmItem(Produto produto);

	/**
	 * Remove o produto do pedido, independente de sua quantidade.
	 * @param produto
	 */
	public void removerItem(Produto produto);

	public void adicionarDesconto(Operacao desconto);

	public void adicionarCobranca(Operacao cobranca);

	public void adidiconarOperacao(Operacao operacao);

	/**
	 * @return o valor da soma de cada produto vezes sua quantidade no pedido
	 */
	public BigDecimal calcularSubtotal();

	/**
	 * @return o subtotal e as operações de desconto e cobrança do pedido.
	 * @see #calcularSubtotal
	 */
	public BigDecimal calcularTotal();

	/**
	 * Altera o estado do pedido para {@link Estado#FECHADO}.
	 * Após isso o pedido não pode mais ser alterado.
	 */
	public void fecharPedido();
	
	/**
	 * Altera o estado do pedido para {@link Estado#CANCELADO}.
	 * Após isso o pedido não pode mais ser alterado.
	 */
	public Pedido cancelarPedido();
	
	/* Metodos de busca */
	public List<Pedido> buscarPorEstado(Estado estado);

	public default void deletar( UUID id ) {
		return;
	}
}
