package Projet.Projet.controller;

import java.util.ArrayList;
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
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.model.Aventurier;
import Projet.Projet.model.Competence;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.EtatAventurier;

@Controller
public class AventurierController {
	@Autowired
	IAventurierDaoJpaRepository daoAventurier;

	@Autowired
	IEquipementDaoJpaRepository daoEquipement;

	@Autowired
	ICompetenceDaoJpaRepository daoCompetence;

	@Autowired
	IArgentDaoJpaRepository daoArgent;

	@GetMapping("/aventurier")
	public String findAll(Model model) {
		model.addAttribute("argent", daoArgent.findById(1).get().getSomme());
		model.addAttribute("aventuriers", daoAventurier.findAll());

		return "aventurier";
	}

	@GetMapping("/ajouter-aventurier")
	@PreAuthorize("hasRole('ADMIN')")
	public String ajouter(Model model) {
		model.addAttribute("competences", daoCompetence.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("argent", daoArgent.findById(1).get().getSomme());

		return "creationAventurier";
	}

	@GetMapping("/modifier-aventurier")
	@PreAuthorize("hasRole('ADMIN')")
	public String modifier(@RequestParam int id, Model model) {
		model.addAttribute("competences", daoCompetence.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("argent", daoArgent.findById(1).get().getSomme());
		model.addAttribute("aventurier", daoAventurier.findById(id).get());

		return "creationAventurier";
	}

	@PostMapping({ "/ajouter-aventurier", "/modifier-aventurier" })
	@PreAuthorize("hasRole('ADMIN')")
	public String sauvegarder(@RequestParam(required = false) List<Integer> competencesId, @RequestParam String isRecru,
			Aventurier aventurier) {
		aventurier.setCompetences(new ArrayList<Competence>());

		if (competencesId == null) {
			competencesId = new ArrayList<Integer>();
		}

		for (int i : competencesId) {
			aventurier.getCompetences().add(daoCompetence.findById(i).get());
		}

		if (aventurier.getEtat() == null) {
			aventurier.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());
		}

		if (isRecru.equals("true")) {
			aventurier.setRecru(true);
		}

		daoAventurier.save(aventurier);

		return "redirect:/ajouter-aventurier";
	}

	@GetMapping("/recruter-aventurier")
	public String recruter(@RequestParam int id) {
		Aventurier aventurier = daoAventurier.findById(id).get();

		aventurier.setRecru(true);
		aventurier.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());
		daoArgent.findById(1).get().subSomme(aventurier.getCout());
		daoAventurier.save(aventurier);

		return "redirect:/aventurier";
	}

	@GetMapping("/supprimer-aventurier")
	@PreAuthorize("hasRole('ADMIN')")
	public String supprimer(@RequestParam int id) {
		daoAventurier.delete(daoAventurier.findById(id).get());

		return "redirect:/ajouter-aventurier";
	}

	@GetMapping("/renvoyer-aventurier")
	public String renvoyer(@RequestParam int id) {
		daoAventurier.deleteById(id);

		return "redirect:/aventurier";
	}

	@GetMapping("desequiper-aventurier")
	public String desequiper(@RequestParam int equipementId, Model model) {
		model.addAttribute("aventuriers", daoAventurier.findAll());

		Equipement monEquipement = daoEquipement.findById(equipementId).get();
		monEquipement.setAventurier(null);
		daoEquipement.save(monEquipement);
		return "redirect:/aventurier";
	}

	@GetMapping("soigner-aventurier")
	public String soigner(@RequestParam int id) {
		Aventurier monAventurier = daoAventurier.findById(id).get();

		if (monAventurier.getEtat().toString().toLowerCase().equals("blesse"))
			daoArgent.findById(1).get().subSomme(100);
		monAventurier.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());
		daoAventurier.save(monAventurier);
		return "redirect:/aventurier";
	}
}
