package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.SiteDAO;
import com.sd.oc.model.Site;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class SiteDAOImpl implements SiteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Site find(int id) {
        return entityManager.find(Site.class, id);
    }

    @Override
    @Transactional
    public void create(Site site) {
        entityManager.persist(site);
    }

    @Override
    public void update(Site site) {

    }

    @Override
    public void delete(Site site) {

    }
}
