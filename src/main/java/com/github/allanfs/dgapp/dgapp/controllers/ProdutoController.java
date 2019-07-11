package com.github.allanfs.dgapp.dgapp.controllers;

import com.github.allanfs.dgapp.dgapp.pedido.model.Produto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProdutoController
 */
@RestController
@RequestMapping(name = "ProdutoController", path="/produtos")
public class ProdutoController extends AbstractController<Produto> {

  
}