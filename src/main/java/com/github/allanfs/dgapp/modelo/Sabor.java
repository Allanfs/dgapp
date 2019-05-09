package com.github.allanfs.dgapp.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @Column(name="id_sabor")
    @Getter private Long id;

    @Getter @Setter private String nome;
    
    // private double preco;
    @Getter @Setter private boolean especial;

    @ManyToMany
    @JoinTable(name="sabor_possui_recheios",
    	joinColumns= {@JoinColumn(name="id_sabor")}, 
    	inverseJoinColumns={@JoinColumn(name="id_recheio")},
    	foreignKey=@ForeignKey(name="FK_SABOR_ID" ),
    	inverseForeignKey=@ForeignKey(name="FK_RECHEIO_ID"))
    @Getter @Setter private Set<Recheio> recheios;
    
    @OneToMany
    @Getter @Setter private Set<SaborPreco> precosTamanhos;
    
    @ManyToOne
    @Getter @Setter private Categoria categoria;

}