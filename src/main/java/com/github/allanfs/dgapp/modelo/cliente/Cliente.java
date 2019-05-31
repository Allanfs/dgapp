package com.github.allanfs.dgapp.modelo.cliente;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name="id_cliente")
    @Getter private Long id;

    @OneToMany
    @JoinColumn( name="id_telefone_fk")
    @Getter @Setter private Set<Telefone> telefone;

    @OneToMany
    @Getter @Setter private Set<Endereco> endereco;

    @Getter @Setter private String nome;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Getter @Setter private Date dataNascimento;
    @Getter @Setter private String cpf;

    @Getter @Setter private String instagram;
    @Getter @Setter private String facebook;
    
    @Email
    @Getter @Setter private String email;

    @Getter @Setter private Date dataCadastro;

}
