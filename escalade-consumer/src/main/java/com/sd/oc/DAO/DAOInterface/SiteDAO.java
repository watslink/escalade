package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Site;

import java.util.List;

public interface SiteDAO extends GenericDAO<Site, Integer>{

    List<Site> findByDepartement(int departement);
}
