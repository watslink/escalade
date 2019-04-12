package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.model.Longueur;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class LongeurDAOImpl extends GenericDAOImpl<Longueur, Integer> implements LongueurDAO {

    public List<Longueur> getListFromCriteria(){


        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Longueur> q = cb.createQuery(Longueur.class);

        Root<Longueur> c = q.from(Longueur.class);

        Predicate likeRestriction = cb.and(
                cb.equal( c.get("cotation"), "5b"),
                cb.equal( c.get("nombre_points"), "19"),
                cb.equal(c.get("voie").get("secteur").get("site").get("ville"),"Les Ecrennes")
        );

        q.select(c).where(likeRestriction);

        TypedQuery<Longueur> query = em.createQuery(q);

        return query.getResultList();



    }

}
