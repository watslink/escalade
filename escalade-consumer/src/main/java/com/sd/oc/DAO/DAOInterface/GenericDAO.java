package com.sd.oc.DAO.DAOInterface;

import java.util.List;

public interface GenericDAO<T, K> {

    void create(T t);

    void delete(K id);

    T findById(K id);

    void update(T t);

    List<T> findAll();
}
