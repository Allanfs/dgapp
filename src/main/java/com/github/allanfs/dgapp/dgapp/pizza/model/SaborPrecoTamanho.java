package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor_preco_tamanho")
@NoArgsConstructor @AllArgsConstructor
public class SaborPrecoTamanho {
	
	@EmbeddedId
	@JsonIgnore
	@Getter @Setter private SaborPrecoTamanhoEmbeddeId id;
	@Getter @Setter private float preco;
	
	public Tamanho getTamanho() {
		return id.getTamanho();
	}
	
	public void setTamanho( Tamanho tamanho ) {
		id.setTamanho(tamanho);
	}
	
}
