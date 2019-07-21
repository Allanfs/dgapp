package com.github.allanfs.dgapp.dgapp.pedido.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.github.allanfs.dgapp.dgapp.pizza.model.ProdutoPizza;
import com.github.allanfs.dgapp.dgapp.pizza.model.Sabor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Representa a relação entre um {@link Sabor} e um {@link ProdutoPizza}.
 * </p>
 * <p>
 * Um {@link ProdutoPizza} pode possuir vários sabores, e um {@link Sabor} pode
 * estar presente em vários {@link ProdutoPizza}.
 * </p>
 * <p>
 * Deve possuir referencia tanto ao {@link Produto} tanto ao {@link Pedido} que
 * está relacionado. Observe que representam chaves estrangeiras no mapeamente
 * JPA
 * </p>
 */
@Entity(name = "tb_item_sabor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoSabor {

	@Id
	@GeneratedValue(generator = "uuid")
	private UUID id;

	@ManyToOne()
	@JoinColumn(
			name = "id_pedido_fk", referencedColumnName = "id_pedido", 
			foreignKey = @ForeignKey(name = "id_pedido_fk_esta_para_id_pedido"))
	private Pedido pedido;

	@ManyToOne()
	@JoinColumn(
			name = "id_produto_fk", referencedColumnName = "id_produto", 
			foreignKey = @ForeignKey(name = "id_produto_fk_esta_para_id_produto"))
	private ProdutoPizza produto;

	@ManyToOne
	@JoinColumn(name = "id_sabor_fk")
	private Sabor sabor;

	public ItemPedidoSabor(Pedido pedido, ProdutoPizza produto, Sabor sabor) {
		this( (UUID) null , pedido, produto, sabor);
	}
	
}