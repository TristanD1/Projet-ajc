package Projet.Projet;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;

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
		// CreateQuete("Protection de convoi", 500);
		// CreateQuete("Protection de village", 1000);
		// CreateQuete("Protection de Minas Tirith", 5000);
		// CreateQuete("Attaque d'Isengard", 3000);
		// CreateQuete("Destruction de l'Anneau Unique", 100000);
		//
		// AssocierEquipementAventurier(3, 1);
		//
		// AssocierAventurierQuete(1, 3);

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

	public static void AssocierEquipementAventurier(int aventurierId, int equipementId) {
		Equipement monEquipement = new EquipementDaoJpa().findById(equipementId);
		Aventurier monAventurier = new AventurierDaoJpa().findById(aventurierId);

		if (monEquipement.getAventurier() == null) {
			monEquipement.setAventurier(monAventurier);
			new EquipementDaoJpa().save(monEquipement);
		}
	}

	public static void AssocierAventurierQuete(int aventurierId, int queteId) {
		Aventurier monAventurier = new AventurierDaoJpa().findById(aventurierId);
		Quete maQuete = new QueteDaoJpa().findById(queteId);

		if (monAventurier.getQuete() == null) {
			monAventurier.setQuete(maQuete);
			new AventurierDaoJpa().save(monAventurier);
		}
	}
}
