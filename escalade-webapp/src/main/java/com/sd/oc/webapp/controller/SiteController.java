package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.DepartementService;
import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.model.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("utilisateurConnecte")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private DepartementService departementService;


    @GetMapping("/liste_departements")
    public String liste_departements(Model model) {

        model.addAttribute("liste_departements", departementService.getAll());
        return "liste_departements";
    }

    @GetMapping("/liste_sites_par_departement")
    public String liste_site_par_departement(@RequestParam String code_departement, Model model){

        model.addAttribute("liste_sites", siteService.getByCodeDepartement(code_departement));
        return "liste_sites_par_departement";
    }
}
