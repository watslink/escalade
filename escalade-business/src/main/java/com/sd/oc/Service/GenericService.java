package com.sd.oc.Service;

import java.util.List;

public interface GenericService<T, D, K> {
    public T get(K id);
    public void add(T entity);
    public void update(T entity);
    public void remove(T entity);

}
