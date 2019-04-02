package com.sd.oc.webapp.controller;

import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.model.Utilisateur;
import com.sd.oc.utils.BCryptManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InscriptionController {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/inscription")
    public String inscription(Model model){
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String postInscription(@ModelAttribute("utilisateur") Utilisateur utilisateur, @RequestParam String password_confirmation){
        if(!BCryptManagerUtil.passwordencoder().matches(password_confirmation, utilisateur.getMot_de_passe())){

            return "redirect:/inscription?errorPassword";
        }
        for(Utilisateur user:utilisateurDAO.findAll()){
            if(user.getPseudo().equals(utilisateur.getPseudo())){
                return "redirect:/inscription?errorPseudo";
            }
        }

        utilisateurDAO.create(utilisateur);

        return"login";
    }
}
