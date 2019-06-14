package com.github.allanfs.dgapp.dgapp.cliente.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
		
		// o telefone possui uma referencia para o cliente informado?
		if (!telefone.getCliente().getId().equals(cliente.getId())) {
			// erro

			// o cliente possui esse telefone na sua lista?
			if ( !cliente.getTelefone().stream().anyMatch(tele -> telefone.getId().equals(telefone.getId()))) {
				// erro
				// cliente nao possui o telefone informado
			}
		}
		
		// remove o telefone da lista do cliente
		Telefone telefoneRemover = cliente.getTelefone().stream()
				.filter(tele -> telefone.getId().equals(telefone.getId())).findFirst().get();
		
		// remove o telefone
		if (cliente.getTelefone().remove(telefoneRemover)) {
			editar(cliente);
			return cliente;
		}else {
			// erro
			return null;
		}
		
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
		if (obj.getId() == null) {
			throw new ClienteCadastradoException(mensagem.getMessage("cliente.x.ja.cadastrado", new Object[] {obj.getNome()}, Locale.ROOT));
		}else {
			return repo.save(obj);
		}
	}

	@Override
	public List<Cliente> buscarTodos() {
		return repo.findAll();
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
		return null;
	}

	@Override
	public void deletar(UUID id) {
		repo.deleteById(id);
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
