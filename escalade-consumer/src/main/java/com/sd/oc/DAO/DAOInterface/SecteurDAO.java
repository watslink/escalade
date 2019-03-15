package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Secteur;

public interface SecteurDAO {

    Secteur find (int id);
    void create (Secteur secteur);
    void update (Secteur secteur);
    void delete (Secteur secteur);
}
