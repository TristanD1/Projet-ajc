package Projet.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Recompense;

@Controller
public class RecompenseController {
	@Autowired
	IRecompenseDaoJpaRepository daoRecompense;

	@Autowired
	IEquipementDaoJpaRepository daoEquipement;

	@GetMapping("/recompense")
	public String findAll(Model model) {
		List<Recompense> recompenses = daoRecompense.findAll();

		model.addAttribute("recompenses", recompenses);

		return "recompense";
	}

	@GetMapping("/modifier-recompense")
	public String modifier(@RequestParam int id, Model model) {
		List<Recompense> recompenses = daoRecompense.findAll();

		model.addAttribute("recompenses", recompenses);

		Recompense recompense = daoRecompense.findById(id).get();

		model.addAttribute("recompense", recompense);

		return "recompense";
	}

	@PostMapping({ "/recompense", "/modifier-recompense" })
	public String ajouter(Recompense recompense) {
		daoRecompense.save(recompense);

		return "redirect:/recompense";
	}

	@GetMapping("/supprimer-recompense")
	public String supprimer(@RequestParam int id) {
		for (Equipement e : daoEquipement.findAll()) {
			if (e.getRecompense().getId() == id) {
				daoEquipement.deleteById(e.getId());
			}
		}

		daoRecompense.deleteById(id);

		return "redirect:/recompense";
	}
}
