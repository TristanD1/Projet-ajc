package Projet.Projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Projet.Projet.dao.IEquipementDaoJpaRepository;

@Controller
public class EquipementController {
	@Autowired
	IEquipementDaoJpaRepository daoEquipement;
	
	@GetMapping("/equipement")
	public String equipement(Model model) {
		model.addAttribute("equipements", daoEquipement.findAll());
		return "equipement";
	}
}
