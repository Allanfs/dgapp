package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.pizza.Sabor;
import com.github.allanfs.dgapp.repository.SaborRepository;

@Service
public class SaborService implements IService<Sabor> {

	@Autowired
	private SaborRepository saborRepo;

	public Sabor cadastrar(Sabor sabor) {
		return saborRepo.save(sabor);
	}

	public Sabor editar(Sabor sabor) {
		return saborRepo.save(sabor);
	}

	public List<Sabor> buscarTodos() {
		return saborRepo.findAll();
	}

	public Sabor buscarPorId(Long id) {
		return saborRepo.findById(id).orElse(null);
	}

	public void deletar(Long id) {
		saborRepo.deleteById(id);
	}

}
