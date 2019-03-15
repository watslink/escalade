package com.sd.oc.DAO.DAOInterface;

import com.sd.oc.model.Site;

public interface SiteDAO {

    Site find (int id);
    void create (Site site);
    void update (Site site);
    void delete (Site site);
}
