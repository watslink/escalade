package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.VilleDAO;
import com.sd.oc.Service.ServiceInterface.VilleService;
import com.sd.oc.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleServiceImpl extends GenericServiceImpl<Ville, Integer> implements VilleService {

    @Autowired
    public VilleServiceImpl(VilleDAO villeDAO) {
        this.genericDAO = villeDAO;
    }
}
