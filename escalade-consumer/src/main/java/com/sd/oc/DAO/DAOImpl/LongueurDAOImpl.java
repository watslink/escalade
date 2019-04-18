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
public class LongueurDAOImpl extends GenericDAOImpl<Longueur, Integer> implements LongueurDAO {

    public List<Longueur> getListFromCriteria(String cotation, int nombre_points_min,int nombre_points_max,
                                              int hauteur_min, int hauteur_max, String code_departement,
                                              String ville){


        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Longueur> q = cb.createQuery(Longueur.class);

        Root<Longueur> c = q.from(Longueur.class);

        Predicate likeRestriction=cb.and();
        if(!code_departement.equals(""))
        likeRestriction.getExpressions().add(cb.equal(c.get("voie").get("secteur").get("site").get("departement").get("code"),code_departement));
        if(!ville.equals(""))
        likeRestriction.getExpressions().add(cb.equal(c.get("voie").get("secteur").get("site").get("ville"),ville));

        likeRestriction.getExpressions().add(cb.between(c.<Integer>get("hauteur"), hauteur_min , hauteur_max));

        likeRestriction.getExpressions().add(cb.between(c.<Integer>get("nombre_points"), nombre_points_min, nombre_points_max));

        if(!cotation.equals(""))
        likeRestriction.getExpressions().add(cb.equal( c.get("cotation"), cotation));

        q.select(c).where(likeRestriction);

        TypedQuery<Longueur> query = em.createQuery(q);

        return query.getResultList();



    }

}
