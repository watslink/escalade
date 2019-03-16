package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.CommentaireDAO;
import com.sd.oc.model.Commentaire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentaireDAOImpl implements CommentaireDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Commentaire find(int id) {
        return entityManager.find(Commentaire.class, id);
    }

    @Override
    public void create(Commentaire commentaire) {
        entityManager.persist(commentaire);
    }

    @Override
    public void update(Commentaire commentaire) {

    }

    @Override
    public void delete(Commentaire commentaire) {

    }
}
