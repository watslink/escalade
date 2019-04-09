package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("utilisateurConnecte")
public class VoieController {

    @Autowired
    private VoieService voieService;

    @GetMapping("/details_voie")
    public String details_voie(@RequestParam int voie_id, Model model){

        model.addAttribute("voie", voieService.get(voie_id));
        return "details_voie";
    }
}

