package com.sd.oc.DAO.DAOImpl;

import com.sd.oc.DAO.DAOInterface.CommentaireDAO;
import com.sd.oc.model.Commentaire;
import org.springframework.stereotype.Repository;

@Repository
public class CommentaireDAOImpl extends GenericDAOImpl<Commentaire, Integer> implements CommentaireDAO {
}
