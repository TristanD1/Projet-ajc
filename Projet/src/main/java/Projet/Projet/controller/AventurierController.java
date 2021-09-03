package Projet.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IAventurierRecrutementDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.model.AventurierGuilde;
import Projet.Projet.model.AventurierRecrutement;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.EtatAventurier;

@Controller
public class AventurierController {
	@Autowired
	IAventurierGuildeDaoJpaRepository daoAventurierGuilde;

	@Autowired
	IAventurierRecrutementDaoJpaRepository daoAventurierRecrutement;
	
	@Autowired
	IEquipementDaoJpaRepository daoEquipement;

	@GetMapping("/aventurier")
	public String findAll(Model model) {
		List<AventurierRecrutement> aventuriersRecrutement = daoAventurierRecrutement.findAll();
		List<AventurierGuilde> aventuriersGuilde = daoAventurierGuilde.findAll();

		model.addAttribute("aventurierRecrutement", aventuriersRecrutement);
		model.addAttribute("aventurierGuilde", aventuriersGuilde);

		return "aventurier";
	}
	
	@GetMapping("/ajouter-aventurier")
	public String ajouter(Model model) {
		List<AventurierRecrutement> aventuriers = daoAventurierRecrutement.findAll();

		model.addAttribute("aventurierRecrutement", aventuriers);
		
		return "creationAventurier";
	}
	
	@GetMapping("/modifier-aventurier")
	public String modifier(@RequestParam int id, Model model) {
		List<AventurierRecrutement> aventuriers = daoAventurierRecrutement.findAll();

		model.addAttribute("aventurierRecrutement", aventuriers);
		
		AventurierRecrutement aventurier = daoAventurierRecrutement.findById(id).get();

		model.addAttribute("aventurier", aventurier);

		return "creationAventurier";
	}

	@PostMapping({"/ajouter-aventurier", "/modifier-aventurier"})
	public String sauvegarder(AventurierRecrutement aventurier) {
		daoAventurierRecrutement.save(aventurier);

		return "redirect:/ajouter-aventurier";
	}

	@GetMapping("/recruter-aventurier")
	public String recruter(@RequestParam int id) {
		AventurierRecrutement aventurierRecrutement = daoAventurierRecrutement.findById(id).get();
		AventurierGuilde aventurierGuilde = new AventurierGuilde();

		aventurierGuilde.setNom(aventurierRecrutement.getNom());
		aventurierGuilde.setExperience(aventurierRecrutement.getExperience());
		aventurierGuilde.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());

		daoAventurierRecrutement.deleteById(id);
		daoAventurierGuilde.save(aventurierGuilde);

		return "redirect:/aventurier";
	}

	@GetMapping("/supprimer-aventurier")
	public String supprimer(@RequestParam int id) {
		daoAventurierRecrutement.delete(daoAventurierRecrutement.findById(id).get());

		return "redirect:/ajouter-aventurier";
	}

	@GetMapping("/renvoyer-aventurier")
	public String renvoyer(@RequestParam int id) {
		daoAventurierGuilde.deleteById(id);

		return "redirect:/aventurier";
	}
	
	@GetMapping("desequiper-aventurier")
	public String desequiper(@RequestParam int equipementId,Model model){
		List<AventurierRecrutement> aventuriersRecrutement = daoAventurierRecrutement.findAll();
		List<AventurierGuilde> aventuriersGuilde = daoAventurierGuilde.findAll();

		model.addAttribute("aventurierRecrutement", aventuriersRecrutement);
		model.addAttribute("aventurierGuilde", aventuriersGuilde);
		
		Equipement monEquipement = daoEquipement.findById(equipementId).get();
		monEquipement.setAventurier(null);
		daoEquipement.save(monEquipement);
		return "redirect:/aventurier";
	}

}
