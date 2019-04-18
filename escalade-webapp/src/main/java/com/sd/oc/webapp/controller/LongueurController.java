package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.LongueurService;
import com.sd.oc.Service.ServiceInterface.VoieService;
import com.sd.oc.model.Longueur;
import com.sd.oc.model.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LongueurController extends AbstractController{

    @Autowired
    LongueurService longueurService;

    @Autowired
    private VoieService voieService;

    @PostMapping("/ajouter_longueur")
    public String addLongueur(@RequestParam int voie_id,
                              @ModelAttribute Longueur longueur){
        Voie voie=voieService.get(voie_id);
        longueur.setVoie(voie);
        longueurService.add(longueur);
        return "redirect:/details_voie?voie_id="+voie.getVoie_id();
    }

    @GetMapping("/supprimer_longueur")
    public String deleteLongueur(@RequestParam int longueur_id){
        Longueur longueur=longueurService.get(longueur_id);
        longueurService.remove(longueur_id);
        return "redirect:/details_voie?voie_id="+longueur.getVoie().getVoie_id();
    }
}
