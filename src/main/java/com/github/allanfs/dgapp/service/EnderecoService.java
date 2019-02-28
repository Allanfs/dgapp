package com.github.allanfs.dgapp.service;

import java.util.List;

import com.github.allanfs.dgapp.modelo.Endereco;
import com.github.allanfs.dgapp.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IService<Endereco> {
    
    @Autowired
    private EnderecoRepository enderecoRepo;

	@Override
	public Endereco cadastrar(Endereco obj) {
        return enderecoRepo.save(obj);
	}
    
	@Override
	public Endereco editar(Endereco obj) {
        return enderecoRepo.save(obj);
	}
    
	@Override
	public List<Endereco> buscarTodos() {
        return enderecoRepo.findAll();
	}
    
	@Override
	public Endereco buscarPorId(Long id) {
        return enderecoRepo.findById( id ).orElse(null);
	}
    
	@Override
	public void deletar(Long id) {
        enderecoRepo.deleteById( id );
		
	}
    
}
