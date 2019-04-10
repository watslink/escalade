package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public abstract class AbstractController {

    @Autowired
    protected UtilisateurService utilisateurService;

    @ModelAttribute("utilisateurConnecte")
    public Utilisateur getUtilisateurConnecte(){
        System.out.println("rentrer dans getUtilisateur");
        return   utilisateurService.getByPseudo(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
