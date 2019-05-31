package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.cliente.Telefone;
import com.github.allanfs.dgapp.repository.TelefoneRepository;

@Service
public class TelefoneService implements IService<Telefone>{

    @Autowired
    private TelefoneRepository categoriaRepo;

    public Telefone cadastrar(Telefone categoria){
        return categoriaRepo.save(categoria);
    }
    
    public Telefone editar(Telefone categoria){
        return categoriaRepo.save(categoria);
    }

    public List<Telefone> buscarTodos(){
        return categoriaRepo.findAll();
    }

    public Telefone buscarPorId( Long id) {
        return categoriaRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	categoriaRepo.deleteById( id );
    }
    
}