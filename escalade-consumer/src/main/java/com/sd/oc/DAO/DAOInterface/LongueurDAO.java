package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Longueur;

import java.util.List;

public interface LongueurDAO extends GenericDAO<Longueur, Integer>{

    List<Longueur> getListFromCriteria();
}
