package com.github.allanfs.dgapp.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;

    @OneToMany
    @Getter @Setter private Set<Telefone> telefone;

    @OneToMany
    @Getter @Setter private Set<Endereco> endereco;

    @Getter @Setter private String nome;
    @Getter @Setter private Date dataNascimento;
    @Getter @Setter private String cpf;

    @Getter @Setter private String instagram;
    @Getter @Setter private String facebook;
    @Getter @Setter private String email;

    @Getter @Setter private Date dataCadastro;

}
