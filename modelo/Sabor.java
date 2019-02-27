@Entity
@Table("tb_sabor")
public class Sabor implements Serializable{

    private Long id;

    // private double preco;
    private boolean especial;

    private Set<Recheio> recheios;
    private CategoriaSabor categoria;

}