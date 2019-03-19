package com.sd.oc.DAO.DAOInterface;

import java.util.Map;

public interface GenericDAO<T> {


    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
}
