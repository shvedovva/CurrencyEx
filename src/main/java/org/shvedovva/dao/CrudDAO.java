package org.shvedovva.dao;

import java.util.List;

public interface CrudDAO<T, ID>{

    //T findById(ID id);

    List<T> findAll();

    void save(T entity);

    void delete(ID id);
}



