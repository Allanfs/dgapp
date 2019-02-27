package com.github.allanfs.dgapp.service;

import java.util.List;

public interface IService<T> {

    public T cadastrar( T obj );

    public T editar( T obj );

    public List<T> buscarTodos();

    public T buscarPorId( Long id );

    public void deletar( Long id );
}