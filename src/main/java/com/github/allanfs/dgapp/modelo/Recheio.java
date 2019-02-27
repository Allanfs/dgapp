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
@Table(name="tb_recheio")
@NoArgsConstructor @AllArgsConstructor
public class Recheio {

    @Id
    @GeneratedValue
    @Getter private Long id;

    @Getter @Setter private String nome;
    @Getter @Setter private boolean especial;
    
}