package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes("utilisateurConnecte")
public class TopoController {


    @Autowired
    private TopoService topoService;

    @GetMapping("/liste_topos")
    public String liste_topos(Model model){

        model.addAttribute("liste_topos", topoService.getAll());
        return "liste_topos";
    }

    @GetMapping("/detail_topo")
    public String detail_topo(@RequestParam int topo_id, Model model){

        model.addAttribute("topo", topoService.get(topo_id));
        return "detail_topo";
    }

    @GetMapping("/mes_topos")
    public String liste_mes_topos(Model model, HttpSession httpSession){
        return "mes_topos";
    }

}
