package com.github.allanfs.dgapp.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;

    // private double preco;
    @Getter @Setter private boolean especial;

    @OneToMany
    @Getter @Setter private Set<Recheio> recheios;
    
    @ManyToOne
    @Getter @Setter private CategoriaSabor categoria;

}