package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.TopoDAO;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.model.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoServiceImpl extends GenericServiceImpl<Topo, Integer> implements TopoService {

    @Autowired
    public TopoServiceImpl(TopoDAO topoDAO) {
        this.genericDAO = topoDAO;
    }
}
