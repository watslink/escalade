package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.CommentaireService;
import com.sd.oc.Service.ServiceInterface.SecteurService;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.Service.ServiceInterface.VoieService;
import com.sd.oc.model.Commentaire;
import com.sd.oc.model.Secteur;
import com.sd.oc.model.Utilisateur;
import com.sd.oc.model.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller

public class VoieController extends AbstractController{

    @Autowired
    private VoieService voieService;

    @Autowired
    private SecteurService secteurService;

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
                                 @RequestParam int voie_id
                                 ){
        commentaire.setDate(new Date());
        commentaire.setUtilisateur(getUtilisateurConnecte());
        commentaire.setVoie(voieService.get(voie_id));
        commentaireService.add(commentaire);

        return "redirect:/details_voie?voie_id="+voie_id;
    }

    @PostMapping("/ajouter_voie")
    public String addVoie(@RequestParam int secteur_id,
                             @RequestParam String nomVoie){
        Secteur secteur=secteurService.get(secteur_id);
        Voie voie=new Voie(nomVoie, secteur);
        voieService.add(voie);
        return "redirect:/liste_secteurs?site_id="+secteur.getSite().getSite_id();
    }

    @GetMapping("/supprimer_voie")
    public String deleteVoie(@RequestParam int voie_id){
        Voie voie=voieService.get(voie_id);
        voieService.remove(voie_id);
        return "redirect:/liste_secteurs?site_id="+voie.getSecteur().getSite().getSite_id();
    }
}

