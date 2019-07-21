package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.Tamanho;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "sabor")
@Data
@EqualsAndHashCode(exclude = "sabor")
class SaborPrecoTamanhoEmbeddeId implements Serializable {

	@ManyToOne()
	@JoinColumn(
			name = "ID_SABOR_PRECO_TAMANHO", 
			referencedColumnName = "id_sabor", 
			foreignKey = @ForeignKey(
					name = "id_sabor_fk_esta_para_id_sabor"))
	private Sabor sabor;

	@ManyToOne()
	@JoinColumn(
			name = "ID_TAMANHO_PRECO_TAMANHO", 
			referencedColumnName = "id_tamanho", 
			foreignKey = @ForeignKey(
					name = "id_tamnho_fk_esta_para_id_tamanho"))
	private Tamanho tamanho;

}
