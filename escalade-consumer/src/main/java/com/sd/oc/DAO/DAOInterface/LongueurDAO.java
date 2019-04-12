package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Longueur;

import java.util.List;

public interface LongueurDAO extends GenericDAO<Longueur, Integer>{

    List<Longueur> getListFromCriteria(String cotation, int nombre_points_min,int nombre_points_max,
                                       int hauteur_min, int hauteur_max, String code_departement,
                                       String ville);
}
