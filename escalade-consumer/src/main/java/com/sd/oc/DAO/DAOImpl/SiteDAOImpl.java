package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.DepartementDAO;
import com.sd.oc.DAO.DAOInterface.SiteDAO;
import com.sd.oc.model.Departement;
import com.sd.oc.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SiteDAOImpl extends GenericDAOImpl<Site, Integer> implements SiteDAO {


    @Override
    public List<Site> findByDepartement(Departement departement) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Site> q = cb.createQuery(Site.class);
        Root<Site> c = q.from(Site.class);
        q.select(c);
        q.where(em.getCriteriaBuilder().equal(c.get("departement"), departement));

        TypedQuery<Site> query = em.createQuery(q);
        return query.getResultList();
    }

}