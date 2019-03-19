package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl extends GenericServiceImpl<Utilisateur, Integer> implements UtilisateurService {

    @Autowired
    public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO) {
        this.genericDAO = utilisateurDAO;
    }
}
