package com.yosi.services;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAO<T extends Serializable> {

    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public List<T> findAll();
    public T getEntity(int id);
}
