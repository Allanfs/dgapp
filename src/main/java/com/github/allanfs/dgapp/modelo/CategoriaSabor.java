package com.github.allanfs.dgapp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_categoriasabor")
@NoArgsConstructor @AllArgsConstructor
public class CategoriaSabor {

    @Id
    @GeneratedValue
    @Getter private long id;
    
    @Getter @Setter private String nome;
    
}