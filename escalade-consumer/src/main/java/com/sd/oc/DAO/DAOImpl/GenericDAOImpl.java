package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.GenericDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


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
    @Transactional
    public void create(final T t) {
        this.em.persist(t);
    }

    @Override
    @Transactional
    public void delete(final K id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    @Transactional
    public T findById(final K id) {
        return this.em.find(type, id);
    }

    @Override
    @Transactional
    public void update(final T t) {
        this.em.merge(t);
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> q = cb.createQuery(type);
        Root<T> c = q.from(type);
        q.select(c);

        TypedQuery<T> query = em.createQuery(q);
        return query.getResultList();
    }
}