package com.github.allanfs.dgapp.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_promocao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Promocao {

	@Getter @Setter private String nome;
	@Getter @Setter private Date dataInicio;
	@Getter @Setter private Date dataFim;
	
	@Getter @Setter private Set<Produto> produtos;
	
	@Getter @Setter private double valor;
	
}
