package Projet.Projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.AventurierGuilde;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Recompense;

@Controller
public class EquipementController {
	@Autowired
	IEquipementDaoJpaRepository daoEquipement;
	@Autowired
	IRecompenseDaoJpaRepository daoRecompense;
	@Autowired
	IAventurierGuildeDaoJpaRepository daoAventurier;
	
	@GetMapping("/equipement")
	public String equipement(Model model) {
		
		List<Recompense> mesRecompenses = new ArrayList<Recompense>();
		
		for(Recompense rec:daoRecompense.findAll()){
			Hibernate.initialize(rec.getEquipements());
			if(rec.getEquipements().isEmpty()){}
			else {
				mesRecompenses.add(rec);
			}
		};
		model.addAttribute("aventuriers",daoAventurier.findAll());
		model.addAttribute("equipements", mesRecompenses);
		return "equipement";
	}

	@GetMapping("/associer-equipement")
	public String associerEquipementAventurier (@RequestParam int idAventurier, @RequestParam int idEquipement){
		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
		Equipement equipement = daoEquipement.findById(idEquipement).get();
				
		equipement.setAventurier(aventurier);
		daoEquipement.save(equipement);
				
		return "redirect:/equipement";
	}

	@GetMapping("vendre-equipement")
	public String vendreEquipement (Model model,@RequestParam int idRec){
		Recompense maRecompense = daoRecompense.findById(idRec).get();
		for(Equipement equip:maRecompense.getEquipements()){
			if(equip.getAventurier()==null){
				daoEquipement.delete(equip);
				return "redirect:/equipement";
			}
		}
		return "redirect:/equipement";
	}
}
