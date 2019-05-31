package com.github.allanfs.dgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.dgapp.modelo.pedido.Pedido;
import com.github.allanfs.dgapp.repository.PedidoRepository;

@Service
public class PedidoService implements IService<Pedido> {

	@Autowired
    private PedidoRepository pedidoRepo;

    public Pedido cadastrar(Pedido pedido){
        return pedidoRepo.save(pedido);
    }
    
    public Pedido editar(Pedido pedido){
        return pedidoRepo.save(pedido);
    }

    public List<Pedido> buscarTodos(){
        return pedidoRepo.findAll();
    }

    public Pedido buscarPorId( Long id) {
        return pedidoRepo.findById( id ).orElse(null);
    }
    
    public void deletar( Long id ) {
    	pedidoRepo.deleteById( id );
    }

}