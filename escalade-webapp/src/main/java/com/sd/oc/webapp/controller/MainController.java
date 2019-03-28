package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private TopoService topoService;



    @GetMapping("/")
    public String pageAccueil(){
        return "index";
    }

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
}
