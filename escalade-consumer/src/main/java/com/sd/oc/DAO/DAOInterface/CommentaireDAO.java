package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Commentaire;

public interface CommentaireDAO {

    Commentaire find (int id);
    void create (Commentaire commentaire);
    void update (Commentaire commentaire);
    void delete (Commentaire commentaire);
}
