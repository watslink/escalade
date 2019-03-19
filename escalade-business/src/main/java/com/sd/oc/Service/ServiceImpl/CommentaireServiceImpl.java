package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.DAOInterface.CommentaireDAO;
import com.sd.oc.Service.ServiceInterface.CommentaireService;
import com.sd.oc.model.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl extends GenericServiceImpl<Commentaire, Integer> implements CommentaireService {

    @Autowired
    public CommentaireServiceImpl(CommentaireDAO commentaireDAO) {
        this.genericDAO = commentaireDAO;
    }
}
