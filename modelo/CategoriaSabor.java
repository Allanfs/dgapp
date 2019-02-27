package modelo;

@Entity
@Table("tb_categoriasabor")
@NoArgsConstructor @AllArgsConstructor
public class CategoriaSabor {

    @Id
    @GeneratedValue
    @Getter private long id;
    
    @Getter @Setter private String nome;
    
}