package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.VoieDAO;
import com.sd.oc.Service.ServiceInterface.VoieService;
import com.sd.oc.model.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoieServiceImpl extends GenericServiceImpl<Voie, Integer> implements VoieService {

    @Autowired
    public VoieServiceImpl(VoieDAO voieDAO) {
        this.genericDAO = voieDAO;
    }
}
