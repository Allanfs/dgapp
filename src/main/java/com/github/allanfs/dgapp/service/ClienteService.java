package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.cliente.Cliente;
import com.github.allanfs.dgapp.repository.ClienteRepository;

@Service
public class ClienteService implements IService<Cliente>{

    @Autowired
    private ClienteRepository categoriaRepo;

    public Cliente cadastrar(Cliente categoria){
        return categoriaRepo.save(categoria);
    }
    
    public Cliente editar(Cliente categoria){
        return categoriaRepo.save(categoria);
    }

    public List<Cliente> buscarTodos(){
        return categoriaRepo.findAll();
    }

    public Cliente buscarPorId( Long id) {
        return categoriaRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	categoriaRepo.deleteById( id );
    }
    
}