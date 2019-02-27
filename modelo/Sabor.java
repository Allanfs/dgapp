@Entity
@Table("tb_sabor")
@NoArgsConstructor @AllArgsConstructor
public class Sabor implements Serializable{

    @Id
    @GeneratedValue
    @Getter private Long id;

    // private double preco;
    @Getter @Setter private boolean especial;

    @Getter @Setter private Set<Recheio> recheios;
    @Getter @Setter private CategoriaSabor categoria;

}