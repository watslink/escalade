package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.TopoAPreterDAO;
import com.sd.oc.Service.ServiceInterface.TopoAPreterService;
import com.sd.oc.model.TopoAPreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoAPreterServiceImpl extends GenericServiceImpl<TopoAPreter, Integer> implements TopoAPreterService {

    @Autowired
    public TopoAPreterServiceImpl(TopoAPreterDAO topoAPreterDAO) {
        this.genericDAO = topoAPreterDAO;
    }
}
