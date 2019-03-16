package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.TopoAPreterDAO;
import com.sd.oc.model.TopoAPreter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class TopoAPreterDAOImpl implements TopoAPreterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TopoAPreter find(int id) {
        return entityManager.find(TopoAPreter.class, id);
    }

    @Override
    public void create(TopoAPreter topoAPreter) {
        entityManager.persist(topoAPreter);
    }

    @Override
    public void update(TopoAPreter topoAPreter) {

    }

    @Override
    public void delete(TopoAPreter topoAPreter) {

    }
}
