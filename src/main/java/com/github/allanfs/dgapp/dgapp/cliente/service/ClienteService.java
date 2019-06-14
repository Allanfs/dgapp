package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;
import com.github.allanfs.dgapp.dgapp.cliente.model.Endereco;
import com.github.allanfs.dgapp.dgapp.cliente.model.Telefone;
import com.github.allanfs.dgapp.dgapp.cliente.repository.ClienteRepository;
import com.github.allanfs.dgapp.dgapp.cliente.repository.TelefoneRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

@Service
public class ClienteService implements IService<Cliente> {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private TelefoneService telefoneService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
    private MessageSource mensagem;
	
	@Override
	public Cliente cadastrar(Cliente obj) {
		
		if (obj.getTelefone() != null) {

			inserirClienteNoTelefoneCasoNaoTenha(obj);
		}
		
		if (obj.getEndereco() != null) {

			inserirClienteNoEnderecoCasoNaoTenha(obj);
		}
		
		return repo.save(obj);
	}

	/**
	 * Adiciona o telefone no conjunto de telefones do cliente e salva o novo telefone
	 * @param cliente
	 * @param telefone
	 * @return
	 */
	public Cliente cadastrarTelefone(Cliente cliente, Telefone telefone ) {
		
		if(telefone.getCliente() == null) {
			telefone.setCliente(cliente);
		}else {
			// FIXME o que aconteceria aqui?
			telefone.getCliente().getId().equals(cliente.getId());
		}
		
		telefoneService.cadastrar(telefone);
		
		adicionarTelefoneNoCliente(telefone, cliente);
		
		return cliente;
		
	}
	public Cliente removerTelefone(Telefone telefone, Cliente cliente) {
		

		
		return cliente;
		
	}
	/**
	 * Apenas adiciona o telefone no conjunto de telefones do cliente
	 * @param telefone
	 * @param cliente
	 */
	private void adicionarTelefoneNoCliente(Telefone telefone, Cliente cliente) {
		cliente.getTelefone().add(telefone);
	}

	public Cliente adicionarEndereceo(Endereco novoEndereco, Cliente cliente) {
		
		if (novoEndereco.getCliente() == null) {
			novoEndereco.setCliente(cliente);
		}
		
		novoEndereco = enderecoService.cadastrar(novoEndereco);
		
		adicionarEnderecoNoCliente(novoEndereco, cliente);
		
		return cliente;
	}
	
	private void adicionarEnderecoNoCliente(Endereco novoEndereco, Cliente cliente) {
		
		if(cliente.getEndereco() == null) {
			cliente.setEndereco( new HashSet<Endereco>());
		}
		
		cliente.getEndereco().add(novoEndereco);
		
	}

	@Override
	public Cliente editar(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorId(UUID id) {
		Optional<Cliente> clienteOpt = repo.findById(id);
		
		if(clienteOpt.isPresent()) {
			return clienteOpt.get();
		}else {
			throw new EntityNotFoundException(mensagem.getMessage("cliente.inexistente", null, Locale.ROOT));
		}
		
	}

	@Override
	public Cliente buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub
		
	}
	
	private void inserirClienteNoEnderecoCasoNaoTenha(Cliente obj) {
		if (!obj.getEndereco().isEmpty()) {
			Consumer<? super Endereco> setClienteSeForNull = endereco -> {
				if (endereco.getCliente() == null)
					endereco.setCliente(obj);
			};
			obj.getEndereco().forEach(setClienteSeForNull);
		}
	}

	private void inserirClienteNoTelefoneCasoNaoTenha(Cliente obj) {
		if (!obj.getTelefone().isEmpty()) {
			Consumer<? super Telefone> setClienteSeForNull = telefone -> {
				if (telefone.getCliente() == null)
					telefone.setCliente(obj);
			};
			obj.getTelefone().forEach(setClienteSeForNull);
		}
	}

}
