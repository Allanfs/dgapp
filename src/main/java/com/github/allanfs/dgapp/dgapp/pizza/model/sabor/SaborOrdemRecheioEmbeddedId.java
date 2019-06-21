package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;
import com.github.allanfs.dgapp.dgapp.pizza.model.TipoInsumo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dentro de uma classe sabor, os recheios 
 * possuem posições especificas.
 * 
 * Ex.: Molho e mussarela são os primeiros
 * recheios em muitos sabores
 * @author allan
 *
 */

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(value = "sabor")
@EqualsAndHashCode
@Getter @Setter
public class SaborOrdemRecheioEmbeddedId implements Serializable{

	@ManyToOne()
	@JoinColumn(
			name = "ID_SABOR_ORDEM_SABOR", 
			referencedColumnName = "id_sabor", 
			foreignKey = @ForeignKey(
					name = "id_sabor_fk_esta_para_id_sabor"))
	private Sabor sabor;
	
	@ManyToOne()
	@JoinColumn(
			name = "ID_RECHEIO_ORDEM_SABOR", 
			referencedColumnName = "id_recheio", 
			foreignKey = @ForeignKey(
					name = "id_recheio_fk_esta_para_id_recheio"))
	private Recheio recheio;
	
}
