package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.GenericDAO;
import com.sd.oc.Service.ServiceInterface.GenericService;

public abstract class GenericServiceImpl<T, K> implements GenericService<T, K> {


    protected GenericDAO<T,K> genericDAO;

    @Override
    public T get(K id) {
        return genericDAO.find(id);
    }

    @Override
    public void add(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void remove(T entity) {

    }
}
