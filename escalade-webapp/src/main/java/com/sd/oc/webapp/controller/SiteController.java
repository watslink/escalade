package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("utilisateurConnecte")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping("/liste_sites")
    public String liste_site(Model model){

        model.addAttribute("liste_sites", siteService.getAll());
        return "liste_sites";
    }
}
