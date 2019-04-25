package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.TopoDAO;
import com.sd.oc.model.Topo;
import org.springframework.stereotype.Repository;

@Repository
public class TopoDAOImpl extends GenericDAOImpl<Topo, Integer> implements TopoDAO {
}
