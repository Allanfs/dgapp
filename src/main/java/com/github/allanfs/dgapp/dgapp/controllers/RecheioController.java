package com.github.allanfs.dgapp.dgapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;

import io.swagger.annotations.Api;

@Api(value="API REST recheio")
@RestController
@RequestMapping(name = "RecheioController",path = "/recheio")
public class RecheioController extends AbstractController<Recheio>{

}
