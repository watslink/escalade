package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoAPreterService;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.model.TopoAPreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Controller

public class TopoController extends AbstractController{


    @Autowired
    private TopoService topoService;

    @Autowired
    private TopoAPreterService topoAPreterService;

    @GetMapping("/liste_topos")
    public String liste_topos(Model model){

        model.addAttribute("liste_topos", topoService.getAll());
        return "presentation/liste_topos";
    }
    @GetMapping("/addToMy_topos")
    public String add_topos(@RequestParam int topo_id){

        TopoAPreter topoAPreter=new TopoAPreter(true, getUtilisateurConnecte(),topoService.get(topo_id));
        topoAPreterService.update(topoAPreter);

        return "redirect:/liste_topos";
    }

    @PostMapping("/addToMy_toposEmpruntes")
    public String add_emprunt(@RequestParam int topoAPreter_id, @RequestParam String date){

        TopoAPreter topoAPreter=topoAPreterService.get(topoAPreter_id);
        topoAPreter.setUtilisateurEmprunteur(getUtilisateurConnecte());
        try {
            topoAPreter.setDate_retour(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (ParseException e) {
            return "redirect:/emprunter_topo?topo_id="+topoAPreter.getTopoReference().getTopo_id();
        }
        topoAPreter.setDisponible(false);
        topoAPreterService.update(topoAPreter);

        return "redirect:/emprunter_topo?topo_id="+topoAPreter.getTopoReference().getTopo_id();
    }

    @GetMapping("/liste_sites_par_topo")
    public String liste_sites_par_topo(@RequestParam int topo_id, Model model){

        model.addAttribute("topo", topoService.get(topo_id));
        return "presentation/liste_sites_par_topo";
    }

    @GetMapping("/emprunter_topo")
    public String emprunter_topo(@RequestParam int topo_id, Model model){

        model.addAttribute("topo", topoService.get(topo_id));
        model.addAttribute("topoAPreter",new TopoAPreter());
        return "presentation/emprunter_topo";
    }

    @GetMapping("/mes_topos")
    public String liste_mes_topos(){
        return "presentation/mes_topos";
    }

    @GetMapping("/removeFromMy_topos")
    public String remove_topo(@RequestParam int topoAPreter_id){

        TopoAPreter topoAPreter=topoAPreterService.get(topoAPreter_id);
        topoAPreterService.remove(topoAPreter_id);

        return "redirect:/mes_topos";
    }

    @GetMapping("/removeFromMy_emprunts")
    public String remove_emprunt(@RequestParam int topoAPreter_id){

        TopoAPreter topoAPreter=topoAPreterService.get(topoAPreter_id);
        topoAPreter.setUtilisateurEmprunteur(null);
        topoAPreter.setDisponible(true);
        topoAPreter.setDate_retour(null);
        topoAPreterService.update(topoAPreter);
        return "redirect:/mes_emprunts";
    }


    @GetMapping("/mes_emprunts")
    public String liste_mes_emprunts(){
        return "presentation/mes_emprunts";
    }
}
