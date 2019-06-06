package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor_preco_tamanho")
@NoArgsConstructor @AllArgsConstructor
public class SaborPrecoTamanho {
	
	@EmbeddedId
	@Getter @Setter private SaborPrecoTamanhoEmbeddeId id;
	@Getter @Setter private float preco;
}
