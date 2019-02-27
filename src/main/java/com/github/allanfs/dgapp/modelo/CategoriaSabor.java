package com.github.allanfs.dgapp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_categoriasabor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class CategoriaSabor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;
    
    @Getter @Setter private String nome;
    
}