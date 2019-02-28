package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.Promocao;
import com.github.allanfs.dgapp.repository.PromocaoRepository;

@Service
public class PromocaoService implements IService<Promocao>{

    @Autowired
    private PromocaoRepository promocaoRepo;

    public Promocao cadastrar(Promocao promocao){
        return promocaoRepo.save(promocao);
    }
    
    public Promocao editar(Promocao promocao){
        return promocaoRepo.save(promocao);
    }

    public List<Promocao> buscarTodos(){
        return promocaoRepo.findAll();
    }

    public Promocao buscarPorId( Long id) {
        return promocaoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	promocaoRepo.deleteById( id );
    }
    
}