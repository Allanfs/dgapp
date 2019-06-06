package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tamanho")
@NoArgsConstructor @AllArgsConstructor
public class Tamanho {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_tamanho")
	@Getter	@Setter	UUID id;
	@Getter @Setter private String nome;
	@Getter @Setter private int numeroFatias;
	@Getter @Setter private int centimetros;
	@Getter @Setter private float precoPadrao;
}
