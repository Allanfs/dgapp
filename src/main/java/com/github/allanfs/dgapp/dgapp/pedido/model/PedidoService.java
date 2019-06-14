package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.Date;
import java.util.List;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.pedido.service.ClienteNaoCadastradoException;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

public interface PedidoService extends IService<Pedido> {

	/**
	 * Verifica se:
	 * existe
	 * está aberto
	 * o pedido póssui pagamento;
	 *  
	 * @param pedido
	 * @return true caso tenha sido fechado, false caso não
	 */
	public boolean fecharPedido(Pedido pedido);
	
	/**
	 * Acrescenta o valor pago no pedido e caso o valor seja menor que
	 * o valor total, retorna uma operação informando quanto resta pagar.
	 * Caso o valor seja superior ao valor total, retorna uma operação
	 * informando quanto excedeu.
	 * Caso seja igual, retorna uma operação zerada.
	 * @param valor
	 * @param pedido
	 * @return operação informando o valor excedente ou deficiente
	 */
	public Operacao realizarPagamento(float valor, Pedido pedido);
	
	public boolean cancelarPedido(Pedido pedido);
	
	/**
	 * Adiciona um {@link Produto} no pedido como um {@link ItemPedido},
	 * caso o produto ja tenha exista, a quantidade deste produto é incrementada.
	 * 
	 * @param pedido
	 * @param produto
	 * @return
	 */
	public Pedido adicionarProdutoNoPedido(Pedido pedido, Produto produto);
	
	public Pedido removerProdutoNoPedido(Pedido pedido, Produto produto);
	
	/**
	 * @param pedido
	 * @return valor do pedido incluindo operações de desconto e cobrança
	 */
	public float obterValorTotal(Pedido pedido);
	
	/**
	 * @param pedido
	 * @return subtotal do pedido, sem incluir operações de descontro e cobrança
	 */
	public float obterValorSubtotal(Pedido pedido);
	
	/**
	 * Decrementa um produto do pedido. 
	 * Caso excluirTodos seja true, irá remover o produto do pedido
	 * @param pedido {@link Pedido} que possui o produto
	 * @param produto {@link Produto} a ser removido
	 * @param excluirTodos se deve excluir o {@link Produto} do pedido
	 */
	public Pedido removerProdutoNoPedido(Pedido pedido, Produto produto, boolean excluirTodos);
	
	public Pedido inserirEndereco(Pedido pedido, Endereco endereco);
	
	public boolean inserirDesconto( float valor );
	
	public boolean removerDesconto( Operacao desconto );
	
	public boolean inserirCobranca( Operacao cobranca);
	
	public void inserirObservacao(String observacao);
	
	/**
	 * TODO talvez seja o caso criar uma classe Observação
	 * para que seja possivel associar a observação a pedidos,
	 * sabores, e produtos.
	 * @param observacao
	 */
	public void removerObservacao(String observacao);
	
	/**
	 * @return lista de todos os pedidos ja feitos
	 */
	public List<Pedido> buscarPedidos();
	
	/**
	 * @param estado - @link Estado} que os pedidos devem estar
	 * @return lista de pedidos no {@link Estado} informado
	 */
	public List<Pedido> buscarPedidos(Estado estado);
	
	/**
	 * Busca pedido de uma data inicio até a data 
	 * @param inicio
	 * @param fim
	 * @return
	 */
	public List<Pedido> buscarPedidos(Date inicio, Date fim);
	
	/**
	 * @param cliente cadastrado no sistema
	 * @return Retorna todos os pedidos já feitos por um cliente
	 */
	public List<Pedido> buscarPedidos(Cliente cliente) throws ClienteNaoCadastradoException;

	
	public boolean imprimirPedidoResumido(Pedido pedido);
	
	public boolean imprimirPedidoCompleto(Pedido pedido);
}
