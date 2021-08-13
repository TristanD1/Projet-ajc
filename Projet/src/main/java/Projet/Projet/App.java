package Projet.Projet;

import java.util.Random;

import Projet.Projet.DAO.Jpa.AbstractDaoJpa;
import Projet.Projet.DAO.Jpa.AventurierDaoJpa;
import Projet.Projet.DAO.Jpa.EquipementDaoJpa;
import Projet.Projet.DAO.Jpa.QueteDaoJpa;
import model.Aventurier;
import model.Equipement;
import model.Quete;
import model.Etat;

public class App {
	public static void main(String[] args) {

		AssocierAventurierQuete(1, 1);
		EnvoyerEnMission(1);

		AbstractDaoJpa.close();
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

	public static void CreateQuete(String nom, int reussite) {
		Quete maQuete = new Quete();
		maQuete.setIntitule(nom.toLowerCase());
		maQuete.setEtat(Etat.INACHEVEE.toString().toLowerCase());
		maQuete.setProbaReussite(reussite);

		new QueteDaoJpa().save(maQuete);
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

	public static void EnvoyerEnMission(int queteId) {
		Quete maQuete = new QueteDaoJpa().findById(queteId);

		if (maQuete.getAventuriers().size() > 0) {
			int proba = 0;

			for (Aventurier a : maQuete.getAventuriers()) {
				proba += a.getExperience();
				for (Equipement e : a.getEquipements()) {
					proba += e.getBonus();
				}
			}

			System.out.println("bonus : " + proba);
			System.out.println("difficulté : " + maQuete.getProbaReussite());
			double r = new Random().nextDouble();
			System.out.println(r);

			// Faire le test de reussite
			if (r < (double) proba / (proba + maQuete.getProbaReussite())) {
				// Changer le status de la quete si reussite
				maQuete.setEtat(Etat.ACHEVEE.toString().toLowerCase());
				new QueteDaoJpa().save(maQuete);

				for (Aventurier a : maQuete.getAventuriers()) {
					a.setExperience(a.getExperience() + maQuete.getProbaReussite());
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
}
