package Projet.Projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.AventurierGuilde;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Quete;
import Projet.Projet.model.Recompense;

@Controller
public class QueteController {
	@Autowired
	private IQueteDaoJpaRepository daoQuete;

	@Autowired
	private IAventurierGuildeDaoJpaRepository daoAventurier;

	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;

	@Autowired
	private IRecompenseDaoJpaRepository daoRecompense;

	@GetMapping("/quete")
	public String quete(Model model) {
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("equipements", daoEquipement.findAll());

		return "quete";
	}

	@GetMapping("/lancer-quete")
	public String add() {
		return "resultatQuete";
	}

	@PostMapping("/lancer-quete")
	public String lancerQuete() {
		return "redirect:/quete";
	}

	@GetMapping("/ajouter-quete")
	public String ajouter(Model model) {
		model.addAttribute("recompensesQuete", daoRecompense.findAll());

		model.addAttribute("recompenses", daoRecompense.findAll());
		model.addAttribute("quetes", daoQuete.findAll());

		return "creationQuete";

	}

	@GetMapping("/modifier-quete")
	public String modifier(@RequestParam int id, Model model) {
		model.addAttribute("recompenses", daoRecompense.findAll());
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("quete", daoQuete.findById(id).get());

		return "creationQuete";
	}

	@PostMapping({ "/ajouter-quete", "/modifier-quete" })
	public String sauvegarder(@RequestParam int recompenseId, Quete quete) {
		List<Recompense> recompenses = new ArrayList<Recompense>();

		quete.setRecompenses(recompenses);
		quete.getRecompenses().add(daoRecompense.findById(recompenseId).get());

		daoQuete.save(quete);

		return "redirect:/ajouter-quete";
	}

	@GetMapping("/supprimer-quete")
	public String supprimer(@RequestParam int id) {
		daoQuete.deleteById(id);

		return "redirect:/ajouter-quete";
	}

//	@GetMapping("/associer-quete-aventurier")
//	public String associerQueteAventurier(@RequestParam int idAventurier, @RequestParam int idQuete) {
//		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
//		Quete quete = daoQuete.findById(idQuete).get();
//
//		try {
//			if (quete.getId() == aventurier.getQuete().getId()) {
//				aventurier.setQuete(null);
//				daoAventurier.save(aventurier);
//			} else {
//				aventurier.setQuete(null);
//				daoAventurier.save(aventurier);
//				aventurier.setQuete(quete);
//				daoAventurier.save(aventurier);
//			}
//		} catch (Exception e) {
//			aventurier.setQuete(quete);
//			daoAventurier.save(aventurier);
//		}
//
//		return "redirect:/quete";
//	}

	// @GetMapping("/associer-equipement-aventurier")
	// public String associerEquipementAventurier(@RequestParam int idAventurier, @RequestParam int idEquipement) {
	// 	AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
	// 	Equipement equipement = daoEquipement.findById(idEquipement).get();

	// 	equipement.setAventurier(aventurier);
	// 	daoEquipement.save(equipement);

	// 	return "redirect:/quete";
	// }
}
