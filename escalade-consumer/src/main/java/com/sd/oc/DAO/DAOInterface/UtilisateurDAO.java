package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur find (int id);
    void create (Utilisateur utilisateur);
    void update (Utilisateur utilisateur);
    void delete (Utilisateur utilisateur);
}
