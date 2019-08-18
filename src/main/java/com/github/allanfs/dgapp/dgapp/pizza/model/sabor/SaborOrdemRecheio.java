package com.github.allanfs.dgapp.dgapp.pizza.model.sabor;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.allanfs.dgapp.dgapp.pizza.model.Recheio;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Dentro de uma classe sabor, os 
 * @author allan
 *
 */
@Entity(name = "tb_sabor_ordem_recheio")
@NoArgsConstructor @AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"sabor"})
public class SaborOrdemRecheio {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_sor")
	private UUID id;
	
	@ManyToOne()
	@JoinColumn(
			name = "ID_SABOR_FK", 
			referencedColumnName = "id_sabor", 
			foreignKey = @ForeignKey(
					name = "id_sabor_fk_esta_para_id_sabor"))
	@JsonIgnore
	private Sabor sabor;
	
	@ManyToOne()
	@JoinColumn(
			name = "ID_RECHEIO_FK", 
			referencedColumnName = "id_recheio", 
			foreignKey = @ForeignKey(
					name = "id_recheio_fk_esta_para_id_recheio"))
	private Recheio recheio;
	
	private int posicao;
	
	public SaborOrdemRecheio(Sabor saborNovo, Recheio recheio, int i) {
		this(recheio, i);
		this.sabor = saborNovo;
		
	}
	
	public SaborOrdemRecheio(Recheio recheio, Integer i) {
		this.recheio = recheio;
		this.posicao = i;
	}
	
}
