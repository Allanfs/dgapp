package com.github.allanfs.dgapp.dgapp.pizza.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	public SaborPrecoTamanho(Tamanho tamanho, Sabor sabor, float preco) {
		this.setTamanho(tamanho);
		this.setSabor(sabor);
		this.setPreco(preco);
	}
	public Tamanho getTamanho() {
		return criarIDSeNaoExistir().getTamanho();
	}
	
	public void setTamanho( Tamanho tamanho ) {
		criarIDSeNaoExistir().setTamanho(tamanho);
	}
	public void setSabor(Sabor sabor) {
		criarIDSeNaoExistir().setSabor(sabor);
	}
	@JsonBackReference
	public Sabor getSabor() {
		return criarIDSeNaoExistir().getSabor();
	}
	
	private SaborPrecoTamanhoEmbeddeId criarIDSeNaoExistir() {
		if(id == null) {
			id = new SaborPrecoTamanhoEmbeddeId();
		}
		return id;
	}
	
}
