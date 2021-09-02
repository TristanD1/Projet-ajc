package Projet.Projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;


@Controller
public class QueteController {
	@Autowired
	private IQueteDaoJpaRepository daoQuete;
	
	@Autowired
	private IAventurierGuildeDaoJpaRepository daoAventurier;
	
	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;
	
	
	
	
	@GetMapping("/quete")
	public String quete(Model model) {
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("equipements", daoEquipement.findAll());
		
		return "quete";
	}
	
	@GetMapping("/lancer-quete")
	public String add(){
		return "quete";
	}
	
	@PostMapping("/lancer-quete")
	public String lancerQuete(){
		
		return "redirect:/accueil";
	}
	
	
}
