package Projet.Projet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Projet.Projet.dao.IAventurierDaoJpaRepository;
import Projet.Projet.dao.ICompetenceDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.Aventurier;
import Projet.Projet.model.Competence;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.EtatAventurier;
import Projet.Projet.model.Quete;
import Projet.Projet.model.QueteEtat;
import Projet.Projet.model.Recompense;

@Controller
public class QueteController {
	@Autowired
	private IQueteDaoJpaRepository daoQuete;

	@Autowired
	private IAventurierDaoJpaRepository daoAventurier;

	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;

	@Autowired
	private IRecompenseDaoJpaRepository daoRecompense;
	
	@Autowired
	private ICompetenceDaoJpaRepository daoCompetence;

	@GetMapping("/quete")
	public String quete(Model model) {
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("equipements", daoEquipement.findAll());

		return "quete";
	}

	@GetMapping("/lancer-quete")
	public String add(@RequestParam int idQuete, Model model) {
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("aventuriers", daoAventurier.findAll());
		model.addAttribute("equipements", daoEquipement.findAll());
		model.addAttribute("quete", daoQuete.findById(idQuete).get());
		Quete maQuete = daoQuete.findById(idQuete).get();

		if (maQuete.getAventuriers().size() > 0) {
			int proba = 0;

			for (Aventurier a : maQuete.getAventuriers()) {
				proba += a.getExperience();
				for (Equipement e : a.getEquipements()) {
					proba += e.getRecompense().getBonus();
				}
				for (Competence c : daoCompetence.findCommuneByAventurier(a.getId(), a.getQuete().getId())) {
					proba += c.getBonus();
				}
			}

			double r = new Random().nextDouble();

			// Faire le test de reussite
			if (r < (double) proba / (proba + maQuete.getDifficulte())) {
				// Changer le status de la quete si reussite
				maQuete.setEtat(QueteEtat.ACHEVEE.toString().toLowerCase());
				daoQuete.save(maQuete);

				for (Aventurier a : maQuete.getAventuriers()) {
					a.setExperience(a.getExperience() + maQuete.getDifficulte() / maQuete.getAventuriers().size());
				}

				// Choix aleatoire de la recompence parmis le catalogue de la
				// quete
				List<Recompense> mesRecompenses = maQuete.getRecompenses();
				if (mesRecompenses.size() > 0) {
					double r2 = new Random().nextDouble();
					Equipement monEquipement = new Equipement();
					monEquipement.setRecompense(mesRecompenses.get((int) r2 * mesRecompenses.size()));
					daoEquipement.save(monEquipement);
				} 
			} else {
				maQuete.setEtat(QueteEtat.INACHEVEE.toString().toLowerCase());
				daoQuete.save(maQuete);
				for (Aventurier a : maQuete.getAventuriers()) {
					a.setEtat(EtatAventurier.BLESSE.toString().toLowerCase());
				}
			}

			// desassocier les aventuriers
			for (Aventurier a : maQuete.getAventuriers()) {
				a.setQuete(null);
				daoAventurier.save(a);
			}
		} 
		
		return "resultatQuete";
	}

	@PostMapping("/lancer-quete")
	public String lancerQuete() {
		return "redirect:/quete";
	}

	@GetMapping("/ajouter-quete")
	public String ajouter(Model model) {
		model.addAttribute("competences", daoCompetence.findAll());
		model.addAttribute("recompenses", daoRecompense.findAll());
		model.addAttribute("quetes", daoQuete.findAll());

		return "creationQuete";
	}

	@GetMapping("/modifier-quete")
	public String modifier(@RequestParam int id, Model model) {
		model.addAttribute("competences", daoCompetence.findAll());
		model.addAttribute("recompenses", daoRecompense.findAll());
		model.addAttribute("quetes", daoQuete.findAll());
		model.addAttribute("quete", daoQuete.findById(id).get());

		return "creationQuete";
	}

	@PostMapping({ "/ajouter-quete", "/modifier-quete" })
	public String sauvegarder(@RequestParam(required = false) List<Integer> competencesId, @RequestParam(required = false) List<Integer> recompensesId,
			Quete quete) {
		quete.setRecompenses(new ArrayList<Recompense>());
		quete.setCompetences(new ArrayList<Competence>());

		if (competencesId == null) {
			competencesId = new ArrayList<Integer>();
		}

		if (recompensesId == null) {
			recompensesId = new ArrayList<Integer>();
		}

		for (int i : recompensesId) {
			quete.getRecompenses().add(daoRecompense.findById(i).get());
		}

		for (int i : competencesId) {
			quete.getCompetences().add(daoCompetence.findById(i).get());
		}

		daoQuete.save(quete);

		return "redirect:/ajouter-quete";
	}

	@GetMapping("/supprimer-quete")
	public String supprimer(@RequestParam int id) {
		daoQuete.deleteById(id);

		return "redirect:/ajouter-quete";
	}

	// @GetMapping("/associer-quete-aventurier")
	// public String associerQueteAventurier(@RequestParam int idAventurier,
	// @RequestParam int idQuete) {
	// AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
	// Quete quete = daoQuete.findById(idQuete).get();
	//
	// try {
	// if (quete.getId() == aventurier.getQuete().getId()) {
	// aventurier.setQuete(null);
	// daoAventurier.save(aventurier);
	// } else {
	// aventurier.setQuete(null);
	// daoAventurier.save(aventurier);
	// aventurier.setQuete(quete);
	// daoAventurier.save(aventurier);
	// }
	// } catch (Exception e) {
	// aventurier.setQuete(quete);
	// daoAventurier.save(aventurier);
	// }
	//
	// return "redirect:/quete";
	// }

	// @GetMapping("/associer-equipement-aventurier")
	// public String associerEquipementAventurier(@RequestParam int idAventurier,
	// @RequestParam int idEquipement) {
	// AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
	// Equipement equipement = daoEquipement.findById(idEquipement).get();

	// equipement.setAventurier(aventurier);
	// daoEquipement.save(equipement);

	// return "redirect:/quete";
	// }
}
