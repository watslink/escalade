package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.VilleDAO;
import com.sd.oc.model.Ville;
import org.springframework.stereotype.Repository;

@Repository
public class VilleDAOImpl extends GenericDAOImpl<Ville, Integer> implements VilleDAO {
}
