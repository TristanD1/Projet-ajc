package Projet.Projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipementController {
	@GetMapping("/equipement")
	public String equipement() {
		return "equipement";
	}
}
