package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoAPreterService;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.TopoAPreter;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller

public class TopoController extends AbstractController{


    @Autowired
    private TopoService topoService;

    @Autowired
    private TopoAPreterService topoAPreterService;

    @GetMapping("/liste_topos")
    public String liste_topos(Model model){

        model.addAttribute("liste_topos", topoService.getAll());
        return "liste_topos";
    }
    @GetMapping("/addToMy_topos")
    public String add_topos(@RequestParam int topo_id){

        TopoAPreter topoAPreter=new TopoAPreter(true, getUtilisateurConnecte(),topoService.get(topo_id));
        topoAPreterService.update(topoAPreter);

        return "redirect:/liste_topos";
    }

    @GetMapping("/liste_sites_par_topo")
    public String liste_sites_par_topo(@RequestParam int topo_id, Model model){

        model.addAttribute("topo", topoService.get(topo_id));
        return "liste_sites_par_topo";
    }


    @GetMapping("/mes_topos")
    public String liste_mes_topos(){
        return "mes_topos";
    }

    @GetMapping("/removeFromMy_topos")
    public String remove_topos(@RequestParam int topoAPreter_id){

        TopoAPreter topoAPreter=topoAPreterService.get(topoAPreter_id);
        topoAPreterService.remove(topoAPreter_id);

        return "redirect:/mes_topos";
    }

    @GetMapping("/mes_emprunts")
    public String liste_mes_emprunts(){
        return "mes_emprunts";
    }
}
