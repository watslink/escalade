package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.DepartementService;
import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.Service.ServiceInterface.VilleService;
import com.sd.oc.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SiteController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private VilleService villeService;

    @PostMapping("/ajouter_site")
    public String addSite(@RequestParam String departement_code,
                          @RequestParam Integer ville_id,
                          @RequestParam String nom) {
        Site site = new Site(nom, departementService.get(departement_code), villeService.get(ville_id));
        siteService.add(site);
        return "redirect:/liste_sites_par_departement?code_departement=" + departement_code;
    }

    @GetMapping("/supprimer_site")
    public String deleteSite(@RequestParam int site_id, Model model) {
        Site site = siteService.get(site_id);
        siteService.remove(site_id);
        return "redirect:/liste_sites_par_departement?code_departement=" + site.getDepartement().getCode();
    }
}
