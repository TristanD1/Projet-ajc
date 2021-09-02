package Projet.Projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AventurierController {
	@GetMapping("/aventurier")
	public String aventurier() {
		return "aventurier";
	}

}
