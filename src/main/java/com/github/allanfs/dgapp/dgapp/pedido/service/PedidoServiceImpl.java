package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.service.ClienteService;
import com.github.allanfs.dgapp.dgapp.pedido.model.AbstractPedidoService;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class PedidoServiceImpl extends AbstractPedidoService implements PedidoService {

	@Autowired
	private PedidoRepository service;

	@Autowired
	private ClienteService clienteService;

	public PedidoServiceImpl(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido cadastrar() {
		if ( this.pedido != null ) {
			if (this.pedido.getCliente() == null) {
				throw new ClienteNaoInformadoException(message.getMessage("cliente.nao.informado", null, Locale.ROOT) );
				
			}
			if (this.pedido.getCliente().getEndereco() == null) {
				throw new EnderecoNaoInformadoException(message.getMessage("endereco.nao.informado", null, Locale.ROOT) );
			}
		}

		Cliente clienteDoPedido = this.pedido.getCliente();

		if (clienteDoPedido.getEndereco().size() == 1) {

			this.pedido.setEndereco(clienteDoPedido.getEndereco().stream().findFirst().get());

		} else if (clienteDoPedido.getEndereco().size() > 1 || clienteDoPedido.getEndereco().size() == 0) {

			throw new EnderecoNaoInformadoException(message.getMessage("endereco.nao.informado", null, Locale.ROOT));

		}

		validarItens();
		
		Pedido p = service.save(this.pedido);

		long codigoPedido = gerarCodigoDoPedido();
		return null;
	}

	@Override
	public Pedido cadastrar(Pedido obj) throws EnderecoNaoInformadoException {
		
		this.pedido = obj;

		return this.cadastrar();
	}

	private long gerarCodigoDoPedido() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");

		StringBuilder sb = new StringBuilder(sdf.format(Calendar.getInstance().getTime()));

		// sb.append("001");

		long codigoPedido = Long.parseLong(sb.toString());
		return codigoPedido;
	}

	@Override
	public Pedido editar(Pedido obj) throws EntityNotFoundException {
		return null;
	}

	@Override
	public List<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido buscarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
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

}
