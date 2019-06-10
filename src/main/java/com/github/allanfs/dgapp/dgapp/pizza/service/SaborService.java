package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.SaborOrdemRecheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.SaborPrecoTamanho;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;
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

	public Sabor cadastrar(Sabor sabor) {

		validarOrdemRecheios(sabor);
		
		seVazioPreencherPrecosTamanhos(sabor);
		
		sePrecoInvalidoPreencherValorPadrao(sabor);

		return saborRepo.save(sabor);
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
	 * 
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
			
			tamanhoService.buscarTodos().forEach( tamanho -> {
				SaborPrecoTamanho precoDoSaborNoTamanho = new SaborPrecoTamanho();
				precoDoSaborNoTamanho.setTamanho(tamanho);
				precoDoSaborNoTamanho.setPreco(tamanho.getPrecoPadrao());
				precosTamanhos.add( precoDoSaborNoTamanho);
			});
			
			sabor.setPrecos(precosTamanhos);
			
		// caso exista preço
		}else {
		
			sabor.getPrecos().forEach( precoTamanho -> {
				
				if( precoTamanho.getPreco() <= 0 ) {
					precoTamanho.setPreco( precoTamanho.getTamanho().getPrecoPadrao());
					
					if(precoTamanho.getSabor() == null) {
						precoTamanho.setSabor(sabor);
					}
					
				}
			});
		}
	}

	/**
	 * Verifica se o {@linkplain SaborPrecoTamanho} é null ou vazio.
	 * Caso seja, utiliza o valor padrão dos {@linkplain Tamanho tamanhos} cadastrados
	 * @param sabor
	 */
	private void seVazioPreencherPrecosTamanhos(Sabor sabor) {
		
		if( sabor.getPrecos() == null || sabor.getPrecos().isEmpty()) {
			
			Set<SaborPrecoTamanho> precoPadrao = new HashSet<SaborPrecoTamanho>();
			
			tamanhoService.buscarTodos().forEach( tamanho -> {
				precoPadrao.add( new SaborPrecoTamanho() {
					{
						setTamanho( tamanho );
						setPreco( tamanho.getPrecoPadrao() );
						setSabor(sabor);
					}
				});
			});
			
			sabor.setPrecos(precoPadrao);
			
		}
	}

}