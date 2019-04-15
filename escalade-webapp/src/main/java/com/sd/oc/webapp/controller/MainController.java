package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.model.TopoAPreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class MainController extends AbstractController{

    @Autowired
    private TopoService topoService;


    @GetMapping("/")
    public String pageAccueil(Model model){
        List<TopoAPreter> listToposARendre=new ArrayList<>();
        for (TopoAPreter topoAPreter : getUtilisateurConnecte().getListToposEmprunter()) {
            if (topoAPreter.getDate_retour().before(new Date())) {
                listToposARendre.add(topoAPreter);
                model.addAttribute("listToposARendre", listToposARendre);
            }
        }
        return "index";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response, SessionStatus status) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        status.setComplete();
        return "redirect:/login?logout";
    }


}
