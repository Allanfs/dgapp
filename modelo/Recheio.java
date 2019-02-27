@Entity
@Table("tb_recheio")
@NoArgsConstructor @AllArgsConstructor
public class Recheio {

    @Id
    @GeneratedValue
    @Getter private Long id;

    @Getter @Setter private String nome;
    @Getter @Setter private boolean especial;
    
}