package com.sd.oc.DAO.DAOInterface;

import java.util.Map;

public interface GenericDAO<T, K> {


    void create(T t);

    void delete(K id);

    T find(K id);

    void update(T t);
}
