package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.Longueur;

import java.util.List;

public interface LongueurService extends GenericService<Longueur, Integer> {

    List<Longueur> rechercheMulticriteres(String cotation, int nombre_points_min, int nombre_points_max,
                                          int hauteur_min, int hauteur_max, String code_departement,
                                          String ville);
}
