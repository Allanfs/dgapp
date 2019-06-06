package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.UUID;

public interface IService<T> {

    public T cadastrar( T obj );

    public T editar( T obj );

    public List<T> buscarTodos();

    public T buscarPorId( UUID id );

    public void deletar( UUID id );
}