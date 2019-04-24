package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.DepartementService;
import com.sd.oc.model.Departement;
import com.sd.oc.model.Site;
import com.sd.oc.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class DepartementController {


    @Autowired
    private DepartementService departementService;


    @GetMapping("/liste_departements")
    public String listeDepartements(Model model) {

        model.addAttribute("liste_departements", departementService.getAll());
        return "presentation/liste_departements";
    }

    @GetMapping("/liste_sites_par_departement")
    public String listeSiteParDepartement(@RequestParam String code_departement, Model model){
        Departement departement=departementService.get(code_departement);
        model.addAttribute("departement",  departement);
        return "presentation/liste_sites_par_departement";
    }


}
