package com.github.allanfs.dgapp.dgapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

@RestController
@RequestMapping(name = "SaborController", path="/sabor")
public class SaborController extends AbstractController<Sabor>{

}
