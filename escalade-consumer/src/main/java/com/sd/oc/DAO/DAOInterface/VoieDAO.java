package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Voie;

public interface VoieDAO {

    Voie find (int id);
    void create (Voie voie);
    void update (Voie voie);
    void delete (Voie voie);
}
