package Projet.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/competence")
    public String findAll(Model model) {
        List<Competence> competences = daoComptence.findAll();

        model.addAttribute("competences", competences);

        return "competence";
    }

    @GetMapping("/modifier-competence")
    public String modifier(@RequestParam int id, Model model) {
        List<Competence> competences = daoComptence.findAll();

        model.addAttribute("competences", competences);

        Competence competence = daoComptence.findById(id).get();

        model.addAttribute("competence", competence);

        return "competence";
    }

    @PostMapping({ "/competence", "/modifier-competence" })
    public String ajouter(Competence recompense) {
        daoComptence.save(recompense);

        return "redirect:/competence";
    }

    @GetMapping("/supprimer-competence")
    public String supprimer(@RequestParam int id) {
        daoComptence.deleteById(id);

        return "redirect:/competence";
    }
}
