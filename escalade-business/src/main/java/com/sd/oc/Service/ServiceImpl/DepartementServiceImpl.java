package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.DepartementDAO;
import com.sd.oc.Service.ServiceInterface.DepartementService;
import com.sd.oc.model.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl extends GenericServiceImpl<Departement, String> implements DepartementService {

    @Autowired
    public DepartementServiceImpl(DepartementDAO departementDAO) {
        this.genericDAO = departementDAO;
    }
}

