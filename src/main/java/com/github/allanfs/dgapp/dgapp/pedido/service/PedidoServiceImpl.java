package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.service.ClienteService;
import com.github.allanfs.dgapp.dgapp.pedido.model.Estado;
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
	
	@Autowired
	private MessageSource message;
	
	public PedidoServiceImpl(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido cadastrar() {
		return null;
	}
	
	@Override
	public Pedido cadastrar(Pedido obj) throws EnderecoNaoInformadoException  {
		
		Cliente clienteDoPedido = obj.getCliente();
		
		clienteDoPedido = clienteService.buscarPorId(clienteDoPedido.getId());
		
		if (clienteDoPedido.getEndereco().size() == 1) {

			obj.setEndereco(clienteDoPedido.getEndereco().stream().findFirst().get());

		} else if (clienteDoPedido.getEndereco().size() > 1 || clienteDoPedido.getEndereco().size() == 0) {

			throw new EnderecoNaoInformadoException(message.getMessage("endereco.nao.informado", null, Locale.ROOT));

		}

		Pedido p = service.save(obj);
		
		p.setEstado(Estado.ABERTO);
		
		long codigoPedido = gerarCodigoDoPedido();
		p.setCodigo(codigoPedido);
		
		return p;
	}

	private long gerarCodigoDoPedido() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
		
		StringBuilder sb = new StringBuilder( sdf.format( Calendar.getInstance().getTime() ) );

		//sb.append("001");
		
		long codigoPedido = Long.parseLong( sb.toString() );
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
