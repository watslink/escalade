package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.SecteurService;
import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.model.Secteur;
import com.sd.oc.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecteurController {


    @Autowired
    private SecteurService secteurService;

    @Autowired
    private SiteService siteService;

    @PostMapping("/ajouter_secteur")
    public String addSecteur(@RequestParam int site_id,
                          @RequestParam String nom){
        Site site=siteService.get(site_id);
        Secteur secteur = new Secteur(nom, site);
        secteurService.add(secteur);
        return "redirect:/liste_secteurs?site_id="+site_id;
    }

    @GetMapping("/supprimer_secteur")
    public String deleteSecteur(@RequestParam int secteur_id){
        Secteur secteur=secteurService.get(secteur_id);
        secteurService.remove(secteur_id);
        return "redirect:/liste_secteurs?site_id="+secteur.getSite().getSite_id();
    }


}
