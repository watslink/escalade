package com.sd.oc.webapp.controller;

import com.sd.oc.Service.ServiceInterface.SiteService;
import com.sd.oc.Service.ServiceInterface.TopoAPreterService;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.model.Site;
import com.sd.oc.model.Topo;
import com.sd.oc.model.TopoAPreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller

public class TopoController extends AbstractController {

    @Autowired
    private TopoService topoService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private TopoAPreterService topoAPreterService;

    @GetMapping("/liste_topos")
    public String listeTopos(Model model) {

        model.addAttribute("liste_topos", topoService.getAll());
        model.addAttribute("topo", new Topo());
        return "presentation/liste_topos";
    }

    @GetMapping("/addToMy_topos")
    public String addTopos(@RequestParam int topo_id) {

        TopoAPreter topoAPreter = new TopoAPreter(true, getUtilisateurConnecte(), topoService.get(topo_id));
        topoAPreterService.update(topoAPreter);

        return "redirect:/liste_topos";
    }

    @PostMapping("/addToMy_toposEmpruntes")
    public String addEmprunt(@RequestParam int topoAPreter_id, @RequestParam String date) {

        TopoAPreter topoAPreter = topoAPreterService.get(topoAPreter_id);
        topoAPreter.setUtilisateurEmprunteur(getUtilisateurConnecte());
        try {
            topoAPreter.setDate_retour(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (ParseException e) {
            return "redirect:/emprunter_topo?topo_id=" + topoAPreter.getTopoReference().getTopo_id();
        }
        topoAPreter.setDisponible(false);
        topoAPreterService.update(topoAPreter);

        return "redirect:/emprunter_topo?topo_id=" + topoAPreter.getTopoReference().getTopo_id();
    }

    @GetMapping("/liste_sites_par_topo")
    public String listeSitesParTopo(@RequestParam int topo_id, Model model) {

        model.addAttribute("topo", topoService.get(topo_id));
        model.addAttribute("listSites", siteService.getAll());
        return "presentation/liste_sites_par_topo";
    }

    @GetMapping("/emprunter_topo")
    public String emprunterTopo(@RequestParam int topo_id, Model model) {

        model.addAttribute("topo", topoService.get(topo_id));
        model.addAttribute("topoAPreter", new TopoAPreter());
        return "presentation/emprunter_topo";
    }

    @GetMapping("/mes_topos")
    public String listeMesTopos() {
        return "presentation/mes_topos";
    }

    @GetMapping("/removeFromMy_topos")
    public String remove_topo(@RequestParam int topoAPreter_id) {

        topoAPreterService.remove(topoAPreter_id);

        return "redirect:/mes_topos";
    }

    @GetMapping("/removeFromMy_emprunts")
    public String removeEmprunt(@RequestParam int topoAPreter_id) {

        TopoAPreter topoAPreter = topoAPreterService.get(topoAPreter_id);
        topoAPreter.setUtilisateurEmprunteur(null);
        topoAPreter.setDisponible(true);
        topoAPreter.setDate_retour(null);
        topoAPreterService.update(topoAPreter);
        return "redirect:/mes_emprunts";
    }


    @GetMapping("/mes_emprunts")
    public String liste_mes_emprunts(Model model) {
        model.addAttribute("now", new Date());
        return "presentation/mes_emprunts";
    }

    @PostMapping("/ajouter_topo")
    public String addTopo(@ModelAttribute Topo topo) {
        topoService.add(topo);
        return "redirect:/liste_topos";
    }

    @GetMapping("/supprimer_topo")
    public String deleteTopo(@RequestParam int topo_id) {

        topoService.remove(topo_id);
        return "redirect:/liste_topos";
    }

    @PostMapping("/update_sites_topo")
    public String updateSitesTopo(@RequestParam(required = false) List<Integer> listSite_id, @RequestParam int topo_id) {
        Topo topo = topoService.get(topo_id);
        topo.getListSite().clear();
        if (listSite_id != null) {
            for (int site_id : listSite_id) {
                Site site = siteService.get(site_id);
                topo.getListSite().add(site);
            }
        }
        topoService.update(topo);
        return "redirect:/liste_sites_par_topo?topo_id=" + topo_id;
    }
}
