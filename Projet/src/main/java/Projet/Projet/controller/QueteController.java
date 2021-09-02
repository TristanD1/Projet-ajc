package Projet.Projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueteController {
	@GetMapping("/quete")
	public String quete() {
		return "quete";
	}
	
	
}
