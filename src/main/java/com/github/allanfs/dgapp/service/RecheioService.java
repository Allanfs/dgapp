package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.pizza.Recheio;
import com.github.allanfs.dgapp.repository.RecheioRepository;

@Service
public class RecheioService implements IService<Recheio> {

	@Autowired
	private RecheioRepository recheioRepo;
	
	@Override
	public Recheio cadastrar(Recheio recheio) {
		return recheioRepo.save( recheio );
	}

	@Override
	public Recheio editar(Recheio recheio) {
		return recheioRepo.save( recheio );
	}

	@Override
	public List<Recheio> buscarTodos() {
		return recheioRepo.findAll();
	}

	@Override
	public Recheio buscarPorId(Long id) {
		return recheioRepo.findById(id).orElse(null);
	}

	@Override
	public void deletar(Long id) {
		recheioRepo.deleteById( id );
	}

}
