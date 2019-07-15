package com.github.allanfs.dgapp.dgapp.pedido.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;
import com.github.allanfs.dgapp.dgapp.pedido.repository.ProdutoRepository;
import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoServiceImpl
 */
@Service
public class ProdutoServiceImpl implements IService<Produto> {

	@Autowired
	private ProdutoRepository repo;

	@Override
	public Produto cadastrar(Produto obj) {
		return repo.save(obj);
	}

	@Override
	public Produto editar(Produto obj) {
		if (obj.getId() == null) {
			throw new IllegalStateException("Produto não cadastrado");
		} else {
			return repo.save(obj);
		}
	}

	@Override
	public List<Produto> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Produto buscarPorId(UUID id) {
		Optional<Produto> produtoBuscado = repo.findById(id);
		if (produtoBuscado.isPresent()) {
			return produtoBuscado.get();
		} else {
			return null;
		}
	}

	@Override
	public Produto buscarPorNome(String nome) {
		return null;
	}

	@Override
	public void deletar(UUID id) {
		repo.deleteById(id);
	}

	@Override
	public Integer obterQuantidadeDeRegistrosAtivos() {
		return repo.contarQuantidadeDeProdutos();
	}

}