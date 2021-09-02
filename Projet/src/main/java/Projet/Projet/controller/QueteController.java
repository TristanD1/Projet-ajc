package Projet.Projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;

@Controller
public class QueteController {
	@Autowired
	private IQueteDaoJpaRepository daoQuete;
	
	@Autowired
	private IAventurierDaoJpaRepository daoAventurier;
	
	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;
	
	
	
	
	@GetMapping("/quete")
	public String quete(Model model) {
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("equipements", daoEquipement.findAll());
		
		return "quete";
	}
	
	
}
