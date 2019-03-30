package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("utilisateurConnecte")
public class MainController {

    @Autowired
    private TopoService topoService;

    @Autowired
    private UtilisateurService utilisateurService;

    @ModelAttribute("utilisateurConnecte")
    public Utilisateur getUtilisateurConnecte(Model model){
        System.out.println("rentrer dans getUtilisateur");

             return   utilisateurService.getByPseudo(SecurityContextHolder.getContext().getAuthentication().getName());
    }
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
