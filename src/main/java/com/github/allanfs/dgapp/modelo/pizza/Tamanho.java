package com.github.allanfs.dgapp.modelo.pizza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.allanfs.dgapp.modelo.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_tamanho")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Tamanho {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_tamanho")
    @Getter private Long id;
	
	@Getter @Setter private String nome;
	@Getter @Setter private int centimetros;
	@Getter @Setter private int numeroFatias;
	@Getter @Setter private double preco;
	@Getter @Setter private boolean disponivel;
	@ManyToOne
	@Getter @Setter private Categoria categoria;
	
}
