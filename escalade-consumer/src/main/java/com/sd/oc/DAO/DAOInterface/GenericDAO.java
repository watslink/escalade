package com.sd.oc.DAO.DAOInterface;

import java.util.Map;

public interface GenericDAO<T, K> {


    T create(T t);

    void delete(K id);

    T find(K id);

    T update(T t);
}
