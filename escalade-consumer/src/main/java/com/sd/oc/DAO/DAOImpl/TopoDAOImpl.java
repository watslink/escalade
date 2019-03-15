package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.TopoDAO;
import com.sd.oc.model.Topo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TopoDAOImpl implements TopoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Topo find(int id) {
        return entityManager.find(Topo.class, id);
    }

    @Override
    @Transactional
    public void create(Topo topo) {
        entityManager.persist(topo);
    }

    @Override
    public void update(Topo topo) {

    }

    @Override
    public void delete(Topo topo) {

    }
}
