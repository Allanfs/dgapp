package com.github.allanfs.dgapp.dgapp.controllers;

import com.github.allanfs.dgapp.dgapp.pedido.model.Pedido;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.ClienteNaoInformadoException;
import com.github.allanfs.dgapp.dgapp.pedido.service.exceptions.EnderecoNaoInformadoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PedidoController
 */
@RestController
@RequestMapping(name = "PedidoController", path="/pedidos")
public class PedidoController extends AbstractController<Pedido>{


  @ExceptionHandler({ClienteNaoInformadoException.class,  EnderecoNaoInformadoException.class})
  public ResponseEntity<String> componenteNaoInformado( Exception e ){
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
  
}