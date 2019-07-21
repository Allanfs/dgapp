package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_sabor_preco_tamanho")
@NoArgsConstructor @AllArgsConstructor
@Data
public class SaborPrecoTamanho {
	
	@EmbeddedId
	@JsonIgnore
	private SaborPrecoTamanhoEmbeddeId id;
	private float preco;
	
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
