package Projet.Projet;

import java.util.Random;

import Projet.Projet.DAO.Jpa.AbstractDaoJpa;
import Projet.Projet.DAO.Jpa.AventurierDaoJpa;
import Projet.Projet.DAO.Jpa.CompetenceDaoJpa;
import Projet.Projet.DAO.Jpa.EquipementDaoJpa;
import Projet.Projet.DAO.Jpa.QueteDaoJpa;
import Projet.Projet.model.Aventurier;
import Projet.Projet.model.Competence;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Etat;
import Projet.Projet.model.Quete;

public class App {
	public static void main(String[] args) {
		RecuperationAventurier();
		RecuperationEquipement();
		RecuperationCompetence();
		RecuperationQuete();

		// CreateAventurier("Aragorn", 15);
		// CreateAventurier("Legolas", 15);
		// CreateAventurier("Bilbon", 1);
		// CreateAventurier("Gimli", 15);
		// CreateAventurier("Gandalf", 100);
		//
		// CreateEquipement("Dague", 10);
		// CreateEquipement("Epée", 30);
		// CreateEquipement("Arc", 20);
		// CreateEquipement("Fronde", 10);
		// CreateEquipement("Hache", 40);
		// CreateEquipement("Sortilege", 50);
		//
		// CreateQuete("Escorte de convoi", 50);
		// CreateQuete("Protection de village", 100);
		// CreateQuete("Protection de Minas Tirith", 500);
		// CreateQuete("Attaque d'Isengard", 300);
		// CreateQuete("Destruction de l'Anneau Unique", 1000);
		//
		// CreateCompetence("Oeil de Lynx", 10);
		// CreateCompetence("Bravoure", 15);
		// CreateCompetence("Discretion", 5);

		// AssocierEquipementAventurier(2, 1);
		// AssocierEquipementAventurier(1, 2);
		// AssocierEquipementAventurier(3, 2);
		//
		// AssocierAventurierCompetence(1, 2);
		// AssocierAventurierCompetence(1, 3);
		// AssocierAventurierCompetence(2, 1);
		// AssocierAventurierCompetence(2, 3);
		//
		// AssocierQueteCompetence(1, 1);
		// AssocierQueteCompetence(1, 3);
		//
		// AssocierAventurierQuete(1, 5);
		// AssocierAventurierQuete(2, 5);
		//
		// EnvoyerEnMission(5);
	}

	public static void CreateAventurier(String nom, int exp) {
		Aventurier monAventurier = new Aventurier();
		monAventurier.setNom(nom.toLowerCase());
		monAventurier.setExperience(exp);

		new AventurierDaoJpa().save(monAventurier);
	}

	public static void CreateEquipement(String nom, int bonus) {
		Equipement monEquipement = new Equipement();
		monEquipement.setNom(nom.toLowerCase());
		monEquipement.setBonus(bonus);

		new EquipementDaoJpa().save(monEquipement);
	}

	public static void CreateQuete(String nom, int difficulte) {
		Quete maQuete = new Quete();
		maQuete.setIntitule(nom.toLowerCase());
		maQuete.setEtat(Etat.INACHEVEE.toString().toLowerCase());
		maQuete.setDifficulte(difficulte);

		new QueteDaoJpa().save(maQuete);
	}

	public static void CreateCompetence(String nom, int bonus) {
		Competence competence = new Competence();
		competence.setNom(nom);
		competence.setBonus(bonus);

		new CompetenceDaoJpa().save(competence);
	}

	public static void AssocierEquipementAventurier(int equipementId, int aventurierId) {
		Equipement monEquipement = new EquipementDaoJpa().findById(equipementId);
		Aventurier monAventurier = new AventurierDaoJpa().findById(aventurierId);

		monEquipement.setAventurier(monAventurier);
		new EquipementDaoJpa().save(monEquipement);
	}

	public static void AssocierAventurierQuete(int aventurierId, int queteId) {
		Aventurier monAventurier = new AventurierDaoJpa().findById(aventurierId);
		Quete maQuete = new QueteDaoJpa().findById(queteId);

		monAventurier.setQuete(maQuete);
		new AventurierDaoJpa().save(monAventurier);
	}

	public static void AssocierAventurierCompetence(int aventurierId, int competenceId) {
		Aventurier monAventurier = new AventurierDaoJpa().findById(aventurierId);
		Competence maCompetence = new CompetenceDaoJpa().findById(competenceId);

		try {
			monAventurier.getCompetences().add(maCompetence);
			new AventurierDaoJpa().save(monAventurier);
		} catch (Exception e) {

		}
	}

	public static void AssocierQueteCompetence(int queteId, int competenceId) {
		Quete maQuete = new QueteDaoJpa().findById(queteId);
		Competence maCompetence = new CompetenceDaoJpa().findById(competenceId);

		try {
			maQuete.getCompetences().add(maCompetence);
			new QueteDaoJpa().save(maQuete);
		} catch (Exception e) {

		}
	}

	public static void EnvoyerEnMission(int queteId) {
		Quete maQuete = new QueteDaoJpa().findById(queteId);

		if (maQuete.getAventuriers().size() > 0) {
			int proba = 0;

			for (Aventurier a : maQuete.getAventuriers()) {
				proba += a.getExperience();
				for (Equipement e : a.getEquipements()) {
					proba += e.getBonus();
				}
				for (Competence c : new CompetenceDaoJpa().findCommuneByAventurier(a)) {
					proba += c.getBonus();
				}
			}

			System.out.println("bonus : " + proba);
			System.out.println("difficulté : " + maQuete.getDifficulte());
			double r = new Random().nextDouble();
			System.out.println(r);

			// Faire le test de reussite
			if (r < (double) proba / (proba + maQuete.getDifficulte())) {
				// Changer le status de la quete si reussite
				maQuete.setEtat(Etat.ACHEVEE.toString().toLowerCase());
				new QueteDaoJpa().save(maQuete);

				for (Aventurier a : maQuete.getAventuriers()) {
					a.setExperience(a.getExperience() + maQuete.getDifficulte());
				}

				System.out.println("Quete réussie");
			} else {
				System.out.println("Quete échouée");
			}

			// desassocier les aventuriers
			for (Aventurier a : maQuete.getAventuriers()) {
				a.setQuete(null);
				new AventurierDaoJpa().save(a);
			}
		} else {
			System.out.println("pas d'aventuriers associés");
		}
	}

	public static void RecuperationAventurier() {
		for (Aventurier a : new AventurierDaoJpa().findAll()) {
			System.out.println(a.getId() + " - " + a.getNom() + " - " + a.getExperience());
		}
	}

	public static void RecuperationEquipement() {
		for (Equipement e : new EquipementDaoJpa().findAll()) {
			System.out.println(e.getId() + " - " + e.getNom() + " - " + e.getBonus());
		}
	}

	public static void RecuperationQuete() {
		for (Quete q : new QueteDaoJpa().findAll()) {
			System.out.println(q.getId() + " - " + q.getIntitule() + " - " + q.getDifficulte() + " - " + q.getEtat());
		}
	}

	public static void RecuperationCompetence() {
		for (Competence c : new CompetenceDaoJpa().findAll()) {
			System.out.println(c.getId() + " - " + c.getNom() + " - " + c.getBonus());
		}
	}
}
