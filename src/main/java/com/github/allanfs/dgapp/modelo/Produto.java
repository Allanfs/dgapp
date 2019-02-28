package com.github.allanfs.dgapp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_produto")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;
	
	@NotNull
	@Getter @Setter private String nome;
	
	@NotNull
	@Getter @Setter private double precoVenda;
	@Getter @Setter private double precoCusto;
	@Getter @Setter private String descricao;
	
	@ManyToOne
	@Getter @Setter private Categoria categoriaProduto;
	
	@NotNull
	@Getter @Setter private boolean ativo;
	
}
