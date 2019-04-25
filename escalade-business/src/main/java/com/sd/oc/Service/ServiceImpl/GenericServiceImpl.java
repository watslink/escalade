package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.GenericDAO;
import com.sd.oc.Service.ServiceInterface.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class GenericServiceImpl<T, K> implements GenericService<T, K> {

    protected GenericDAO<T, K> genericDAO;

    @Override
    @Transactional(readOnly = true)
    public T get(K id) {
        return genericDAO.findById(id);
    }

    @Override
    @Transactional
    public void add(T entity) {
        genericDAO.create(entity);
    }

    @Override
    @Transactional
    public void update(T entity) {
        genericDAO.update(entity);
    }

    @Override
    @Transactional
    public void remove(K id) {
        genericDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return genericDAO.findAll();
    }
}
