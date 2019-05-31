package com.github.allanfs.dgapp.modelo.pizza;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.allanfs.dgapp.modelo.pedido.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor @AllArgsConstructor
public class Pizza extends Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter private Long id;

    @OneToMany
    @NotNull @NotEmpty
	@Getter @Setter private Set<Sabor> sabores;
    @Getter @Setter private Tamanho base;
    @Getter @Setter private boolean especial;
    
    @Getter @Setter private double preco;
}
