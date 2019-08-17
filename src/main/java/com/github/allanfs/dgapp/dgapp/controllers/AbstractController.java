package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.allanfs.dgapp.dgapp.pizza.service.IService;

/**
 * AbstractController possui metodos e endpoints padrões para qualquer
 * CRUD de entidade.
 */
public class AbstractController<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
	
    @Autowired
    protected IService<T> service;

    @PostMapping
    public ResponseEntity<T> cadastrar( @RequestBody T obj ) {
        obj = service.cadastrar(obj);
        return new ResponseEntity<T>(obj, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deletar(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorUuid(@PathVariable UUID id ) {

        T obj = service.buscarPorId(id);
        
        if (obj != null) {
            return new ResponseEntity<T>( obj , HttpStatus.OK);
        }else{
            return new ResponseEntity<T>( obj , HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity< List<T> > buscarTodos(){
         
        List<T> todos = service.buscarTodos();

        if (todos.isEmpty()) {
        	logger.info("Nenhum registro encontrado:" + this.getClass().getName());
            return new ResponseEntity<List<T>>(todos, HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<T>>(todos, HttpStatus.OK);
        
    }
    
    @GetMapping("/contar")
	public ResponseEntity<Integer> obterQuantidadeDeClientesCadastrados() {
		return new ResponseEntity<Integer>( service.obterQuantidadeDeRegistrosAtivos() , HttpStatus.OK);
	}

    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@RequestBody T obj, @PathVariable UUID id){
    	
    	T consulta = service.buscarPorId(id);
    	if (consulta == null) {
    		return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
		}
    	
    	return new ResponseEntity<T>( service.cadastrar(obj) , HttpStatus.OK);
    }
    
}