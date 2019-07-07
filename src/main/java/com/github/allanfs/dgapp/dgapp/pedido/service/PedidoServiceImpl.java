package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.service.ClienteService;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.repository.PedidoRepository;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class PedidoServiceImpl extends AbstractPedidoService implements PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private ClienteService clienteService;

	public PedidoServiceImpl(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido cadastrar() {
		if ( this.pedido != null ) {
			if (this.pedido.getCliente() == null) {
				throw new ClienteNaoInformadoException(message.getMessage("cliente.nao.informado", null, Locale.ROOT) );
				
			}else if (this.pedido.getCliente().getEndereco() == null) {
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
		
		Pedido p = repo.save(this.pedido);

		long codigoPedido = gerarCodigoDoPedido();
		return p;
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
	public Pedido editar(Pedido obj) {
		this.pedido = obj;
		
		if ( this.pedido != null ) {
			if (this.pedido.getCliente() == null) {
				throw new ClienteNaoInformadoException(message.getMessage("cliente.nao.informado", null, Locale.ROOT) );
				
			}
			if (this.pedido.getCliente().getEndereco() == null) {
				throw new EnderecoNaoInformadoException(message.getMessage("endereco.nao.informado", null, Locale.ROOT) );
			}
		}
		
		if (this.pedido.getId() == null || this.pedido.getNumeroPedido() == null) {
			throw new IllegalArgumentException("Pedido não cadastrado");
		}
		
		validarItens();
		
		return this.repo.save(obj);
		
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
		}else {
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
	public List<Pedido> buscarPorEstado(Estado estado) {
		return repo.findByEstado(estado);
	}

}
