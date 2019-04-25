package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilisateurServiceImpl extends GenericServiceImpl<Utilisateur, Integer> implements UtilisateurService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurServiceImpl() {
        this.genericDAO = utilisateurDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Utilisateur getByPseudo(String pseudo) {
        return utilisateurDAO.findByPseudo(pseudo);
    }
}
