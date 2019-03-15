package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.VoieDAO;
import com.sd.oc.model.Voie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class VoieDaoImpl implements VoieDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Voie find(int id) {
        return entityManager.find(Voie.class, id);
    }

    @Override
    public void create(Voie voie) {
        entityManager.persist(voie);
    }

    @Override
    public void update(Voie voie) {

    }

    @Override
    public void delete(Voie voie) {

    }
}
