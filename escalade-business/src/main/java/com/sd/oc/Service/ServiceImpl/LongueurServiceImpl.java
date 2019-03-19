package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.Service.ServiceInterface.LongueurService;
import com.sd.oc.model.Longueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LongueurServiceImpl extends GenericServiceImpl<Longueur, Integer> implements LongueurService {

    @Autowired
    public LongueurServiceImpl(LongueurDAO longueurDAO) {
        this.genericDAO = longueurDAO;
    }
}
