package com.github.allanfs.dgapp.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
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
    
    @Email
    @Getter @Setter private String email;

    @Getter @Setter private Date dataCadastro;

}
