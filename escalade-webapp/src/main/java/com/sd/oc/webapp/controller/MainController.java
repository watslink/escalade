package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private TopoService topoService;



    @RequestMapping("/")
    public String pageAccueil(){
        return "index";
    }

    @RequestMapping(value="/liste_topos", method= RequestMethod.GET)
    public String liste_topos(Model model){

        model.addAttribute("liste_topos", topoService.findAll());
        return "liste_topos";
    }
}
