package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Longueur;

public interface LongueurDAO {

    Longueur find (int id);
    void create (Longueur longueur);
}
