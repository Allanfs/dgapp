package com.github.allanfs.dgapp.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Produto {

	@NotNull
	@Getter @Setter private String nome;
	
	@NotNull
	@Getter @Setter private double precoVenda;
	@Getter @Setter private double precoCusto;
	@Getter @Setter private String descricao;
	
	@Getter @Setter private Categoria categoriaProduto;
	
	@NotNull
	@Getter @Setter private boolean ativo;
	
}
