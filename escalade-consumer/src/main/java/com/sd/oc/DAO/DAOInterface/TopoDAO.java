package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Topo;

public interface TopoDAO {

    Topo find (int id);
    void create (Topo topo);
    void update (Topo topo);
    void delete (Topo topo);
}
