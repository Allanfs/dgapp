package com.github.allanfs.dgapp.dgapp.pedido.model;

public abstract class FormaPagamento {

	private Pedido pedido;
	private float valorPago;
	
	public FormaPagamento (Pedido pedido) {
		pedido.getPagamentos().add(this);	// o que acontece se esta linha vier depois?
		this.pedido = pedido;
	}
	
	public float obterValorPago() {
		return valorPago;
	}
	
	public void informarValorPagor( float valor ) {
		this.valorPago = valor;
		pedido.setValorPago(this.valorPago);
	}
	
	public void removerPagamento() {
		pedido.setValorPago(-this.valorPago);
	}
	
	public void excluirPagamento() {
		pedido.getPagamentos().remove(this);
	}
	public void removerEExcluirPagamento() {
		removerPagamento();
		pedido.getPagamentos().remove(this);
	}
}
