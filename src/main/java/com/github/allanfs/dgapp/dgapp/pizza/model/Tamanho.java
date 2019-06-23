package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Entity(name = "tb_tamanho")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor 
@Data
public class Tamanho {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_tamanho")
	private UUID id;
	private String nome;
	private int numeroFatias;
	private int numeroMaximoSabores;
	private int centimetros;
	private float precoPadrao;
	
}
