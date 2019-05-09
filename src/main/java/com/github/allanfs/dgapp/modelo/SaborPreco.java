package com.github.allanfs.dgapp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="preco_sabor_no_tamanho")
@NoArgsConstructor
@AllArgsConstructor
public class SaborPreco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_saborPreco")
	@Getter private Long id;
	
    @ManyToOne
	@Getter @Setter private Sabor sabor;
	
    @ManyToOne
	@Getter @Setter private Tamanho tamanho;
	
	@Getter @Setter private double preco;
}
