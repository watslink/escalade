package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.model.Longueur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class LongeurDAOImpl implements LongueurDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Longueur find(int id) {

        return entityManager.find(Longueur.class, id);

    }

    @Override
    @Transactional
    public void create(Longueur longueur) {
        entityManager.persist(longueur);
    }
}
