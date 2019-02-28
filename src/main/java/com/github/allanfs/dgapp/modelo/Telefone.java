package com.github.allanfs.dgapp.modelo;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

public class Telefone {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;

    @Getter @Setter private Cliente cliente;

    @Getter @Setter private Integer ddd;
    @Getter @Setter private String numero;
    @Getter @Setter private boolean whatsapp;
    @Getter @Setter private String observacao;

}
