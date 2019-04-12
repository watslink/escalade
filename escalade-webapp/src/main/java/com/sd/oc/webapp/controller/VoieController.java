package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.CommentaireService;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.Service.ServiceInterface.VoieService;
import com.sd.oc.model.Commentaire;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller

public class VoieController {

    @Autowired
    private VoieService voieService;

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/details_voie")
    public String details_voie(@RequestParam int voie_id, Model model){

        model.addAttribute("voie", voieService.get(voie_id));
        model.addAttribute("commentaire", new Commentaire());
        return "presentation/details_voie";
    }

    @PostMapping("/details_voie")
    public String commenter_voie(@ModelAttribute Commentaire commentaire,
                                 @RequestParam int voie_id,
                                 @SessionAttribute("utilisateurConnecte") Utilisateur utilisateur
                                 ){
        commentaire.setDate(new Date());
        commentaire.setUtilisateur(utilisateur);
        commentaire.setVoie(voieService.get(voie_id));
        commentaireService.add(commentaire);

        return "redirect:/details_voie?voie_id="+voie_id;
    }
}

