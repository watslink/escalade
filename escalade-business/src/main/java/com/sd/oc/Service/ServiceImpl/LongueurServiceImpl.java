package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.Service.ServiceInterface.LongueurService;
import com.sd.oc.model.Longueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LongueurServiceImpl extends GenericServiceImpl<Longueur, Integer> implements LongueurService {

    @Autowired
    LongueurDAO longueurDAO;

    public LongueurServiceImpl(LongueurDAO longueurDAO) {
        this.genericDAO = longueurDAO;
    }

    @Override
    public List<Longueur> rechercheMulticriteres(String cotation, int nombre_points_min, int nombre_points_max, int hauteur_min, int hauteur_max, String code_departement, String ville) {
        return longueurDAO.getListFromCriteria(cotation, nombre_points_min, nombre_points_max, hauteur_min, hauteur_max, code_departement, ville);
    }
}
