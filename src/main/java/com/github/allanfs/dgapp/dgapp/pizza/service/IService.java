package com.github.allanfs.dgapp.dgapp.pizza.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Os métodos se reponsabilizam de verificar
 * a consistencia dos dados, e caso não estejam
 * corretos, devem lançar exceções, as quais devem
 * ser tratadas por quem fizer uso.
 * @author allan
 *
 */
public interface IService<T> {
	static final Logger logger = LoggerFactory.getLogger(IService.class);
    public T cadastrar( T obj );

    /**
     * @param obj
     * @return obj atualizado
     * @throws EntityNotFoundException
     */
    public T editar( T obj );

    public List<T> buscarTodos();

    public T buscarPorId( UUID id );
    
    public T buscarPorNome( String nome );

    public void deletar( UUID id );

	public Integer obterQuantidadeDeRegistrosAtivos();
}