package com.github.allanfs.dgapp.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter private Long id;
	@Getter @Setter private String nome;
	@Getter @Setter private Date dataInicio;
	@Getter @Setter private Date dataFim;
	
	@OneToMany(targetEntity=Produto.class)
	@Getter @Setter private Set<Produto> produtos;
	
	@Getter @Setter private double valor;
	
}
