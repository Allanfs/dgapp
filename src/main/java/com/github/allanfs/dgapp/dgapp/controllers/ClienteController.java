package com.github.allanfs.dgapp.dgapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.cliente.model.Cliente;

/**
 * ClienteController
 */
@RestController
@RequestMapping(name = "ClienteController",path = "/clientes")
public class ClienteController extends AbstractController<Cliente> {

}