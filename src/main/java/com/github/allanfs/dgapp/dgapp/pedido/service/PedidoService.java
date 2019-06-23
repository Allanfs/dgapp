package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.math.BigDecimal;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.model.Operacao;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

public interface PedidoService extends IService<Pedido> {

	public void adicionarEndereco(Endereco endereco);

	public void adicionarCliente(Cliente cliente);

	public int obterQuantidadeDeItensUnicos();

	public int obterQuantidadeDeItens();

	public void adicionarItem(Produto produto);

	public void removerUmItem(Produto produto);

	public void removerItem(Produto produto);

	public void adicionarDesconto(Operacao desconto);

	public void adicionarCobranca(Operacao cobranca);

	public void adidiconarOperacao(Operacao operacao);

	public BigDecimal calcularSubtotal();

	public BigDecimal calcularTotal();

	public void fecharPedido();

}
