import modelo.CategoriaSabor;
public class CategoriaSaborService implements IService<CategoriaSabor>{

    @Autowired
    private CategoriaRepository categoriaRepo;

    public void cadastrar(CategoriaSabor categoria){
        categoriaRepo.save(categoria);
    }
    
    public void editar(CategoriaSabor categoria){
        categoriaRepo.update(categoria);
    }

    public List<CategoriaSabor> buscarTodos(){
        return categoriaRepo.listAll();
    }

    public CategoriaSabor buscarUm( Long id) {
        return categoriaRepo.findById( id );
    }

}