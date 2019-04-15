package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SiteController {


    @Autowired
    private SiteService siteService;

    @GetMapping("/liste_secteurs")
    public String liste_sites_par_topo(@RequestParam int site_id, Model model){

        model.addAttribute("site", siteService.get(site_id));
        return "presentation/liste_secteurs";
    }

    @PostMapping("/liste_sites_par_departement")
    public String addSite(@ModelAttribute Site site){
        siteService.add(site);
        return "redirect:/liste_sites_par_departement";
    }
}
