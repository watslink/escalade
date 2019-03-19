package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.SecteurDAO;
import com.sd.oc.Service.ServiceInterface.SecteurService;
import com.sd.oc.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecteurServiceImpl extends GenericServiceImpl<Secteur, Integer> implements SecteurService {

    @Autowired
    public SecteurServiceImpl(SecteurDAO secteurDAO) {
        this.genericDAO = secteurDAO;
    }
}
