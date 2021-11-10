package com.johnreah.accounts.hibernate;

import java.util.List;

public interface DAO<T extends EntityPOJO> {

    public void create(T entity);

    public void edit(T entity);

    public void destroy(Long id);

    public List<T> findAll();

    public List<T> find(int maxResults, int firstResult);

    public T findById(Long id);

    public int count();

}
