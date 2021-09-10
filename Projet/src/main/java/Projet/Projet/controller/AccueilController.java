package Projet.Projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Projet.Projet.dao.IArgentDaoJpaRepository;

@Controller
public class AccueilController {
	@Autowired
	IArgentDaoJpaRepository daoArgent;
	
	@GetMapping("/accueil")
	public String accueil(Model model) {
		model.addAttribute("argent", daoArgent.findById(1).get().getSomme());
		return "accueil";
	}
}
