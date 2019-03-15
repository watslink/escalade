package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.SecteurDAO;
import com.sd.oc.model.Secteur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SecteurDAOImpl implements SecteurDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Secteur find(int id) {
        return entityManager.find(Secteur.class, id);
    }

    @Override
    @Transactional
    public void create(Secteur secteur) {
        entityManager.persist(secteur);
    }

    @Override
    public void update(Secteur secteur) {

    }

    @Override
    public void delete(Secteur secteur) {

    }
}
