package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.exception.PosicaoNegativaException;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
import com.github.allanfs.dgapp.dgapp.pizza.model.sabor.SaborOrdemRecheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.sabor.SaborPrecoTamanho;
import com.github.allanfs.dgapp.dgapp.pizza.repository.SaborRepository;

@Service
public class SaborService implements IService<Sabor> {

	@Autowired
	private SaborRepository saborRepo;

	@Autowired
	private RecheioService recheioService;
	
	@Autowired
	private TamanhoService tamanhoService;

	@Autowired
	private MessageSource mensagem;

	/* (non-Javadoc)
	 * Se recheios for vazio? cria um vazio
	 * Se precosTamanho for vazio? insere todos os tamanhos com seus valores padrao 
	 * @see com.github.allanfs.dgapp.dgapp.pizza.service.IService#cadastrar(java.lang.Object)
	 */
	public Sabor cadastrar(Sabor sabor) {
		
		List<Tamanho> todosTamanhosCadastrados = tamanhoService.buscarTodos();
		
		Sabor saborCadastrado = sabor;
		
		if(saborCadastrado.getRecheios() == null) {
			saborCadastrado.setRecheios( new HashSet<SaborOrdemRecheio>() );
		}
		
		validarOrdemRecheios(saborCadastrado);
		
		if(saborCadastrado.getPrecos() == null || saborCadastrado.getPrecos().isEmpty()) {
			preencherPrecosTamanhos(sabor);
		}
		
		preencherTamanhoInexistentesEm(saborCadastrado, todosTamanhosCadastrados);
		
		sePrecoInvalidoPreencherValorPadrao(saborCadastrado);
		
		return saborRepo.save(saborCadastrado);
	}

	/**
	 * Caso exista algum {@link SaborPrecoTamanho} que não informe o preço de algum {@link Tamanho} cadastrado:
	 * o método irá inserir o tamanho não informado.
	 * 
	 * Isos quer dizer que: {@link SaborPrecoTamanho} deve ter a mesma quantidade de {@link Tamanho}s cadastrados
	 * 
	 * @param sabor
	 * @param todosTamanhosCadastrados
	 */
	private void preencherTamanhoInexistentesEm(Sabor sabor, List<Tamanho> todosTamanhosCadastrados) {
		
		// não leia esta parte, vá para última linha
		Consumer<? super Tamanho> adicionaTamanhoAoSabor = tamanho -> {
					sabor.getPrecos().add( new SaborPrecoTamanho(tamanho, sabor, tamanho.getPrecoPadrao()) );
				};
				
		Predicate<? super Tamanho> tamanhosQueNaoEstaoNaLista = tamanho -> {
			Predicate<? super SaborPrecoTamanho> tamanhoComIdsIguais = precoTamanho -> precoTamanho.getTamanho().getId().equals( tamanho.getId() );
			return sabor.getPrecos().stream().noneMatch(tamanhoComIdsIguais);
		};
		
		todosTamanhosCadastrados.stream().filter(tamanhosQueNaoEstaoNaLista).forEach(adicionaTamanhoAoSabor);
	}

	public Sabor editar(Sabor sabor) {

		return saborRepo.save(sabor);
	}

	public List<Sabor> buscarTodos() {
		return saborRepo.findAll();
	}

	public Sabor buscarPorId(UUID id) {
		Optional<Sabor> saborBuscado = saborRepo.findById(id);

		if (!saborBuscado.isPresent()) {
			throw new EntityNotFoundException(mensagem.getMessage("sabor.inexistente", null, Locale.ROOT));
		}
		return saborBuscado.get();
	}

	public Sabor buscarPorNome(String nome) {
		Optional<Sabor> saborBuscado = saborRepo.findByNome(nome);

		if (!saborBuscado.isPresent()) {
			throw new EntityNotFoundException(
					mensagem.getMessage("sabor.x.inexistente", new Object[] { nome }, Locale.ROOT));
		}
		return saborBuscado.get();
	}

	public void deletar(UUID id) {

		Optional<Sabor> saborBuscado = saborRepo.findById(id);

		if (!saborBuscado.isPresent()) {
			throw new EntityNotFoundException(mensagem.getMessage("sabor.inexistente", null, Locale.ROOT));
		}

		saborRepo.delete(saborBuscado.get());
	}
	
	public boolean recheioExisteNoSabor( String nomeRecheio, Sabor sabor ) {
		return sabor
				.getRecheios()
				.stream()
				.anyMatch(saborOrdem -> saborOrdem.getRecheio().getNome().equalsIgnoreCase(nomeRecheio));
	}
	
	public boolean recheioExisteNoSabor( UUID idRecheio, Sabor sabor ) {
		return sabor
				.getRecheios()
				.stream()
				.anyMatch(saborOrdem -> saborOrdem.getRecheio().getId().equals(idRecheio));
	}
	
	/**
	 * Verifica se os dados do {@linkplain SaborOrdemRecheio ordem recheio} são validos.
	 * Verificando se as posições são maiores que 0, e se possui ID
	 * @param sabor
	 */
	private void validarOrdemRecheios(Sabor sabor) {
		sabor.getRecheios().forEach(saborOrdemRecheio -> {

			if ( saborOrdemRecheio.getId() != null ) {
				
				// obtem o recheio se existir
				saborOrdemRecheio.setRecheio(recheioService.buscarPorId(saborOrdemRecheio.getRecheio().getId()));
				
				// verifica a posicao do recheio
				if (saborOrdemRecheio.getPosicao() < 0) {
					Object[] args = {saborOrdemRecheio.getRecheio().getNome(), saborOrdemRecheio.getPosicao(), sabor.getNome()};
					throw new PosicaoNegativaException(mensagem.getMessage("recheio.posicao.negativa", args, Locale.ROOT));
				}

				// settar o sabor
				if (saborOrdemRecheio.getSabor() == null) {
					saborOrdemRecheio.setSabor(sabor);
				}
			} else {
				return;
			}

		});
	}

	/**
	 * Caso o preço do {@link SaborPrecoTamanho} for inválido
	 * utiliza o preço {@linkplain Tamanho#getPrecoPadrao() preço padrão do tamanho}
	 * @param sabor
	 */
	private void sePrecoInvalidoPreencherValorPadrao(Sabor sabor) {

		if(sabor.getPrecos() == null) {
			HashSet<SaborPrecoTamanho> precosTamanhos = new HashSet<SaborPrecoTamanho>();
			
			inserirTamanhosCadastradosNo(precosTamanhos);
			
			sabor.setPrecos(precosTamanhos);
			
		// caso exista preço
		}else {
		
			sabor.getPrecos().forEach( precoTamanho -> {
				
				if( precoTamanho.getTamanho() == null ) {
					/* 
					 * caso apenas o preço seja informado (ou nao),
					 * não tem como saber para qual tamanho ele está apontando 
					 */
					return;
				}
				
				if( precoTamanho.getPreco() <= 0 ) {
					/*
					 * utiliza o preço padrão do tamanho existente
					 */
					precoTamanho.setPreco( precoTamanho.getTamanho().getPrecoPadrao());
				}
				
				if(precoTamanho.getSabor() == null) {
					precoTamanho.setSabor(sabor);
				}
				
			});
		}
	}

	private void inserirTamanhosCadastradosNo(Set<SaborPrecoTamanho> precosTamanhos) {
		tamanhoService.buscarTodos().forEach( tamanho -> {
			
			SaborPrecoTamanho precoDoSaborNoTamanho = new SaborPrecoTamanho();
			
			precoDoSaborNoTamanho.setTamanho(tamanho);
			precoDoSaborNoTamanho.setPreco(tamanho.getPrecoPadrao());
			
			precosTamanhos.add( precoDoSaborNoTamanho);
		});
	}

	/**
	 * Utiliza o valor padrão dos {@linkplain Tamanho tamanhos} cadastrados
	 * para inseri-los em {@link SaborPrecoTamanho} no sabor.
	 * @param sabor
	 */
	private void preencherPrecosTamanhos(Sabor sabor) {

		Set<SaborPrecoTamanho> precoPadrao = new HashSet<SaborPrecoTamanho>();

		tamanhoService.buscarTodos().forEach(tamanho -> {
			precoPadrao.add(new SaborPrecoTamanho() {
				{
					setTamanho(tamanho);
					setPreco(tamanho.getPrecoPadrao());
					setSabor(sabor);
				}
			});
		});

		sabor.setPrecos(precoPadrao);

	}

}