public interface IService<T> {

    public void cadastrar( T obj );

    public void editar( T obj );

    public List<T> buscarTodos();

    public T buscarUm( Long id);

}