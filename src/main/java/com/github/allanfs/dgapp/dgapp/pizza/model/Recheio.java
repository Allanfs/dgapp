package com.github.allanfs.dgapp.dgapp.pizza.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "tb_recheio")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor 
@EqualsAndHashCode(callSuper=true)
@Getter	@Setter	
public class Recheio extends TipoInsumo{
	
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name="id_recheio")
	private UUID id;
	private String nome;
	
}
