package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.DepartementDAO;
import com.sd.oc.DAO.DAOInterface.SiteDAO;
import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl extends GenericServiceImpl<Site, Integer> implements SiteService {



    @Autowired
    public SiteServiceImpl(SiteDAO siteDAO) {
        this.genericDAO = siteDAO;
    }
}

