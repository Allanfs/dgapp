package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_recheio")
@NoArgsConstructor @AllArgsConstructor
public class Recheio extends TipoInsumo{

	
//	@GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator",
//	parameters = {
//			@Parameter()
//				name = "uuid_gen_strategy_class",
//				value= "org.hibernate.id.uuid.CustomVersion"
//	})
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_recheio")
	@Getter	@Setter	UUID id;
	@Getter	@Setter	String nome;

}
