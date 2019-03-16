package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.TopoAPreter;

public interface TopoAPreterDAO {

    TopoAPreter find (int id);
    void create (TopoAPreter topoAPreter);
    void update (TopoAPreter topoAPreter);
    void delete (TopoAPreter topoAPreter);
}


