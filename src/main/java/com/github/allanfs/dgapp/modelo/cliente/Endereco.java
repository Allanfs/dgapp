package com.github.allanfs.dgapp.modelo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Endereco {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_endereco")
    @Getter private Long id;

    @NotNull
	@Getter @Setter private String logradouro;
    
    @NotNull
	@Getter @Setter private String bairro;
	@Getter @Setter private String complemento;
	
	@NotNull
	@Getter @Setter private String numero;
	@Getter @Setter private String cep;
	
    @Getter @Setter private String localidade;
    @Getter @Setter private String uf;
	
}
