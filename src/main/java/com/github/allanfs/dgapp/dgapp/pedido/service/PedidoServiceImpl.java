package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.service.ClienteService;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class PedidoServiceImpl extends AbstractPedidoService implements PedidoService {

	@Autowired
	private ClienteService clienteService;

	public PedidoServiceImpl(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido cadastrar(Pedido pedido) {
		if (pedido != null) {
			if (pedido.getCliente() == null) {
				throw new ClienteNaoInformadoException(message.getMessage("cliente.nao.informado", null, Locale.ROOT));

			} else if (pedido.getEndereco() == null) {
				throw new EnderecoNaoInformadoException(
						message.getMessage("endereco.nao.informado", null, Locale.ROOT));
			} else {

			}
		}

		/*
		 * Se o endereço do pedido E o cliente tenha mais de um endereço
		 */
		Cliente clienteDoPedido = pedido.getCliente();
		if (pedido.getEndereco() == null && clienteDoPedido.getEndereco().size() > 1) {

			throw new EnderecoNaoInformadoException(message.getMessage("endereco.nao.informado", null, Locale.ROOT));

		} else if (clienteDoPedido.getEndereco().size() == 1) {

			pedido.setEndereco(clienteDoPedido.getEndereco().stream().findFirst().get());

		}

		if (validarItens(pedido)) {

			pedido.setEstado(Estado.ABERTO);

		}

		Pedido p = repo.save(pedido);

		long codigoPedido = gerarCodigoDoPedido();
		return p;
	}

	private long gerarCodigoDoPedido() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");

		StringBuilder sb = new StringBuilder(sdf.format(Calendar.getInstance().getTime()));

		// sb.append("001");

		long codigoPedido = Long.parseLong(sb.toString());
		return codigoPedido;
	}

	@Override
	public Pedido editar(Pedido pedido) {

		if (pedido != null) {
			if (pedido.getCliente() == null) {
				throw new ClienteNaoInformadoException(message.getMessage("cliente.nao.informado", null, Locale.ROOT));

			}
			if (pedido.getCliente().getEndereco() == null) {
				throw new EnderecoNaoInformadoException(
						message.getMessage("endereco.nao.informado", null, Locale.ROOT));
			}
		}

		if (pedido.getId() == null || pedido.getNumeroPedido() == null) {
			throw new IllegalArgumentException("Pedido não cadastrado");
		}

		validarItens(pedido);

		return this.repo.save(pedido);

	}

	@Override
	public List<Pedido> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Pedido buscarPorId(UUID id) {
		Optional<Pedido> pedidoBuscado = repo.findById(id);
		if (pedidoBuscado.isPresent()) {
			return pedidoBuscado.get();
		} else {
			return null;
		}
	}

	@Override
	public Pedido buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer obterQuantidadeDeRegistrosAtivos() {
		return repo.contarQuantidadeDePedidos();
	}

}
