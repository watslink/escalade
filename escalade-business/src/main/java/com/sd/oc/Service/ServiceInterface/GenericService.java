package com.sd.oc.Service.ServiceInterface;

import java.util.List;

public interface GenericService<T, K> {
    public T get(K id);
    public void add(T entity);
    public void update(T entity);
    public void remove(K id);
    public List<T> getAll();

}
