package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.LongueurService;
import com.sd.oc.model.Longueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RechercheMultiController {

    @Autowired
    LongueurService longueurService;

    @GetMapping("/recherche_multi")
    public String getRechecheMulti() {
        return "presentation/recherche_multi";
    }

    @PostMapping("/recherche_multi")
    public String rechercheMulti(@RequestParam String cotation,
                                 @RequestParam int[] nombre_points,
                                 @RequestParam int[] hauteur,
                                 @RequestParam String code_departement, @RequestParam String ville,
                                 Model model) {

        List<Longueur> longueurList = longueurService.rechercheMulticriteres(cotation,
                nombre_points[0], nombre_points[1],
                hauteur[0], hauteur[1], code_departement, ville);

        model.addAttribute("longueurList", longueurList);
        return "presentation/recherche_multi";
    }
}
