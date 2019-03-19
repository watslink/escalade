package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void create(final T t) {
        this.em.persist(t);
    }

    @Override
    public void delete(final K id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T find(final K id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public void update(final T t) {
         this.em.merge(t);
    }
}