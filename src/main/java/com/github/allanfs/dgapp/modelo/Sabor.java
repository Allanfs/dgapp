package com.github.allanfs.dgapp.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_sabor")
@NoArgsConstructor @AllArgsConstructor
public class Sabor implements Serializable{

    @Id
    @GeneratedValue
    @Getter private Long id;

    // private double preco;
    @Getter @Setter private boolean especial;

    @Getter @Setter private Set<Recheio> recheios;
    @Getter @Setter private CategoriaSabor categoria;

}