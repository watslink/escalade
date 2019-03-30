package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.model.Utilisateur;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur, Integer> implements UtilisateurDAO {


    @Override
    public Utilisateur findByPseudo(String pseudo) {
        return em.unwrap(Session.class).byNaturalId(Utilisateur.class).using("pseudo",pseudo).load();
    }
}
