package com.github.allanfs.dgapp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_recheio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Recheio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_recheio")
    @Getter private Long id;

    @NotNull
    @Getter @Setter private String nome;
    
    @Getter @Setter private boolean especial = false;
    @Getter @Setter private boolean disponivel = false;
    
}