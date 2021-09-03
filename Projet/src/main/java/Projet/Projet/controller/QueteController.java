package Projet.Projet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.model.AventurierGuilde;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Quete;


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
	
	@GetMapping("/associer-quete-aventurier")
	public String associerQueteAventurier(@RequestParam int idAventurier, @RequestParam int idQuete){
		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
		Quete quete = daoQuete.findById(idQuete).get();
		
		aventurier.setQuete(quete);
		daoAventurier.save(aventurier);
				
		return "redirect:/quete";
	}
	
	@GetMapping("/associer-equipement-aventurier")
	public String associerEquipementAventurier(@RequestParam int idAventurier, @RequestParam int idEquipement){
		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
		Equipement equipement = daoEquipement.findById(idEquipement).get();
		
	
		equipement.setAventurier(aventurier);
		daoEquipement.save(equipement);	
		
		return "redirect:/quete";
	}
	
	
	
	@PostMapping("/lancer-quete")
	public String lancerQuete(){
		
		 
		
		return "redirect:/accueil";
	}
	
	
}
