package Projet.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IArgentDaoJpaRepository;
import Projet.Projet.dao.IAventurierDaoJpaRepository;
import Projet.Projet.dao.ICompetenceDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.model.Competence;

@Controller
public class CompetenceController {
    @Autowired
    ICompetenceDaoJpaRepository daoComptence;

    @Autowired
    IAventurierDaoJpaRepository daoAventurier;

    @Autowired
    IQueteDaoJpaRepository daoQuete;

    @Autowired
	IArgentDaoJpaRepository daoArgent;

    @GetMapping("/competence")
    @PreAuthorize("hasRole('ADMIN')")
    public String findAll(Model model) {
        List<Competence> competences = daoComptence.findAll();

        model.addAttribute("competences", competences);
        model.addAttribute("argent", daoArgent.findById(1).get().getSomme());

        return "competence";
    }

    @GetMapping("/modifier-competence")
    @PreAuthorize("hasRole('ADMIN')")
    public String modifier(@RequestParam int id, Model model) {
        List<Competence> competences = daoComptence.findAll();

        model.addAttribute("competences", competences);

        Competence competence = daoComptence.findById(id).get();

        model.addAttribute("argent", daoArgent.findById(1).get().getSomme());
        model.addAttribute("competence", competence);

        return "competence";
    }

    @PostMapping({ "/competence", "/modifier-competence" })
    public String ajouter(Competence recompense) {
        daoComptence.save(recompense);

        return "redirect:/competence";
    }

    @GetMapping("/supprimer-competence")
    @PreAuthorize("hasRole('ADMIN')")
    public String supprimer(@RequestParam int id) {
        daoComptence.deleteById(id);

        return "redirect:/competence";
    }
}
