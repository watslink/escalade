package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.SiteDAO;
import com.sd.oc.model.Site;
import org.springframework.stereotype.Repository;

@Repository
public class SiteDAOImpl extends GenericDAOImpl<Site, Integer> implements SiteDAO {
}