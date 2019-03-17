package com.github.allanfs.dgapp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_telefone")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_telefone")
    @Getter private Long id;

    @ManyToOne
    @JoinColumn( name="id_cliente_fk")
    @Getter @Setter private Cliente cliente;

    @Getter @Setter private Integer ddd;
    @Getter @Setter private String numero;
    @Getter @Setter private boolean whatsapp;
    @Getter @Setter private String observacao;

}
