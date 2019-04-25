package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Utilisateur;

public interface UtilisateurDAO extends GenericDAO<Utilisateur, Integer> {

    Utilisateur findByPseudo(final String name);
}
