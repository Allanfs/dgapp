package com.github.allanfs.dgapp.dgapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

@RestController
@RequestMapping(name = "SaborController", path="/sabores")
public class SaborController extends AbstractController<Sabor>{

  /*
  /sabor/5165-4565-54654-5465/recheio
  /sabor/bacalhau+com+catupiry/recheio
  */
  @GetMapping("/{id}/recheio")
  public ResponseEntity<List<Recheio>> obterRecheios(@PathVariable UUID id){
    // obter o recheio de {id}
    // obter os recheios
    List<Recheio> recheios = null;
    return new ResponseEntity<List<Recheio>>(recheios, HttpStatus.OK);
  }
  
  @PostMapping("/{id}/recheio")
  Sabor adicionarRecheio(@PathVariable UUID id, @RequestBody Recheio recheio){
    return null;
  }
  
}
