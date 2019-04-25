package com.sd.oc.Service.ServiceInterface;

import java.util.List;

public interface GenericService<T, K> {

    T get(K id);

    void add(T entity);

    void update(T entity);

    void remove(K id);

    List<T> getAll();

}
