package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.model.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Utilisateur find(int id) {
        return entityManager.find(Utilisateur.class, id);
    }

    @Override
    public void create(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
    }

    @Override
    public void update(Utilisateur utilisateur) {

    }

    @Override
    public void delete(Utilisateur utilisateur) {

    }
}
