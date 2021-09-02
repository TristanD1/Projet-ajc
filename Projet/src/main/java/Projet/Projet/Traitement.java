package Projet.Projet;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projet.Projet.dao.IAventurierDaoJpaRepository;
import Projet.Projet.dao.ICompetenceDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.Aventurier;
import Projet.Projet.model.Recompense;
import Projet.Projet.model.Competence;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.EtatAventurier;
import Projet.Projet.model.QueteEtat;
import Projet.Projet.model.Quete;

@Service
public class Traitement {
	@Autowired
	private IAventurierDaoJpaRepository daoAventurier;

	@Autowired
	private ICompetenceDaoJpaRepository daoCompetence;

	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;

	@Autowired
	private IQueteDaoJpaRepository daoQuete;

	@Autowired
	private IRecompenseDaoJpaRepository daoRecompense;

	private void CreateAventurier(String nom, int exp) {
		Aventurier monAventurier = new Aventurier();
		monAventurier.setNom(nom.toLowerCase());
		monAventurier.setExperience(exp);
		monAventurier.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());

		daoAventurier.save(monAventurier);
	}

	private void CreateRecompense(String nom, int bonus) {
		Recompense maRecompense = new Recompense();
		maRecompense.setNom(nom.toLowerCase());
		maRecompense.setBonus(bonus);

		daoRecompense.save(maRecompense);
	}

	public void InitDatabase() {
		CreateAventurier("Aragorn", 15);
		CreateAventurier("Legolas", 15);
		CreateAventurier("Bilbon", 1);
		CreateAventurier("Gimli", 15);
		CreateAventurier("Gandalf", 100);

		CreateQuete("Escorte de convoi", 50);
		CreateQuete("Protection de village", 100);
		CreateQuete("Protection de Minas Tirith", 500);
		CreateQuete("Attaque d'Isengard", 300);
		CreateQuete("Destruction de l'Anneau Unique", 1000);

		CreateCompetence("Oeil de Lynx", 10);
		CreateCompetence("Bravoure", 15);
		CreateCompetence("Discretion", 5);

		CreateRecompense("Dague", 10);
		CreateRecompense("Epée", 30);
		CreateRecompense("Arc", 20);
		CreateRecompense("Fronde", 10);
		CreateRecompense("Hache", 40);
		CreateRecompense("Sortilege", 50);
	}

	private void CreateQuete(String nom, int difficulte) {
		Quete maQuete = new Quete();
		maQuete.setIntitule(nom.toLowerCase());
		maQuete.setEtat(QueteEtat.INACHEVEE.toString().toLowerCase());
		maQuete.setDifficulte(difficulte);

		daoQuete.save(maQuete);
	}

	private void CreateCompetence(String nom, int bonus) {
		Competence competence = new Competence();
		competence.setNom(nom);
		competence.setBonus(bonus);

		daoCompetence.save(competence);
	}

	public void AssocierEquipementAventurier(int equipementId, int aventurierId) {
		Equipement monEquipement = daoEquipement.findById(equipementId).orElseThrow(RuntimeException::new);
		Aventurier monAventurier = daoAventurier.findById(aventurierId).orElseThrow(RuntimeException::new);

		monEquipement.setAventurier(monAventurier);
		daoEquipement.save(monEquipement);
	}

	public void AssocierAventurierQuete(int aventurierId, int queteId) {
		Aventurier monAventurier = daoAventurier.findById(aventurierId).orElseThrow(RuntimeException::new);
		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);

		if (monAventurier.getEtat().toString().equals(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase())) {
			monAventurier.setQuete(maQuete);
		} else {
			System.out.println(monAventurier.getNom() + " est blessé !");
		}

		daoAventurier.save(monAventurier);
	}

	@Transactional
	public void AssocierAventurierCompetence(int aventurierId, int competenceId) {
		boolean isAttribuee = false;

		Aventurier monAventurier = daoAventurier.findById(aventurierId).orElseThrow(RuntimeException::new);
		Competence maCompetence = daoCompetence.findById(competenceId).orElseThrow(RuntimeException::new);

		for (Competence c : monAventurier.getCompetences()) {
			if (c.getId() == maCompetence.getId()) {
				System.out.println("Compétence déjà attribuée !");
				isAttribuee = true;
				break;
			}
		}

		if (!isAttribuee) {
			monAventurier.getCompetences().add(maCompetence);
			daoAventurier.save(monAventurier);
		}
	}

	@Transactional
	public void AssocierQueteCompetence(int queteId, int competenceId) {
		boolean isAttribuee = false;

		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);
		Competence maCompetence = daoCompetence.findById(competenceId).orElseThrow(RuntimeException::new);

		for (Competence c : maQuete.getCompetences()) {
			if (c.getId() == maCompetence.getId()) {
				System.out.println("Compétence déjà attribuée !");
				isAttribuee = true;
				break;
			}
		}

		if (!isAttribuee) {
			maQuete.getCompetences().add(maCompetence);
			daoQuete.save(maQuete);
		}
	}

	@Transactional
	public void AssocierQueteRecompense(int queteId, int recompenseId) {
		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);
		Recompense maRecompense = daoRecompense.findById(recompenseId).orElseThrow(RuntimeException::new);

		maQuete.getRecompenses().add(maRecompense);
		daoQuete.save(maQuete);
	}

	@Transactional
	public void DissocierAventurierCompetence(int aventurierId, int competenceId) {
		Aventurier monAventurier = daoAventurier.findById(aventurierId).orElseThrow(RuntimeException::new);
		Competence maCompetence = daoCompetence.findById(competenceId).orElseThrow(RuntimeException::new);

		monAventurier.getCompetences().remove(maCompetence);
		daoAventurier.save(monAventurier);
	}

	@Transactional
	public void DissocierQueteCompetence(int queteId, int competenceId) {
		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);
		Competence maCompetence = daoCompetence.findById(competenceId).orElseThrow(RuntimeException::new);

		maQuete.getCompetences().remove(maCompetence);
		daoQuete.save(maQuete);
	}

	@Transactional
	public void DissocierQueteRecompense(int queteId, int recompenseId) {
		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);
		Recompense maRecompense = daoRecompense.findById(recompenseId).orElseThrow(RuntimeException::new);

		maQuete.getRecompenses().remove(maRecompense);
		daoQuete.save(maQuete);
	}

	@Transactional
	public void EnvoyerEnMission(int queteId) {
		Quete maQuete = daoQuete.findById(queteId).orElseThrow(RuntimeException::new);

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

			System.out.println("bonus : " + proba);
			System.out.println("difficulté : " + maQuete.getDifficulte());
			double r = new Random().nextDouble();
			System.out.println(r);

			// Faire le test de reussite
			if (r < (double) proba / (proba + maQuete.getDifficulte())) {
				// Changer le status de la quete si reussite
				maQuete.setEtat(QueteEtat.ACHEVEE.toString().toLowerCase());
				daoQuete.save(maQuete);

				for (Aventurier a : maQuete.getAventuriers()) {
					a.setExperience(a.getExperience() + maQuete.getDifficulte() / maQuete.getAventuriers().size());
				}

				System.out.println("Quete réussie");

				// Choix aleatoire de la recompence parmis le catalogue de la
				// quete
				List<Recompense> mesRecompenses = maQuete.getRecompenses();
				if (mesRecompenses.size() > 0) {
					double r2 = new Random().nextDouble();
					Equipement monEquipement = new Equipement();
					monEquipement.getRecompense().setNom(mesRecompenses.get((int) r2 * mesRecompenses.size()).getNom());
					monEquipement.getRecompense().setBonus(mesRecompenses.get((int) r2 * mesRecompenses.size()).getBonus());
					daoEquipement.save(monEquipement);
				} else {
					System.out.println("Pas de récompenses disponibles !");
				}

			} else {
				for (Aventurier a : maQuete.getAventuriers()) {
					a.setEtat(EtatAventurier.BLESSE.toString().toLowerCase());
					System.out.println(a.getNom() + " a été blessé au combat");
				}
				System.out.println("Quete échouée");
			}

			// desassocier les aventuriers
			for (Aventurier a : maQuete.getAventuriers()) {
				a.setQuete(null);
				daoAventurier.save(a);
			}
		} else {
			System.out.println("pas d'aventuriers associés");
		}
	}

	public void RecuperationAventurier() {
		for (Aventurier a : daoAventurier.findAll()) {
			System.out.println(a.getId() + " - " + a.getNom() + " - " + a.getExperience());
		}
	}

	public void RecuperationEquipement() {
		for (Equipement e : daoEquipement.findAll()) {
			System.out.println(e.getId() + " - " + e.getRecompense().getNom() + " - " + e.getRecompense().getBonus());
		}
	}

	public void RecuperationQuete() {
		for (Quete q : daoQuete.findAll()) {
			System.out.println(q.getId() + " - " + q.getIntitule() + " - " + q.getDifficulte() + " - " + q.getEtat());
		}
	}

	public void RecuperationCompetence() {
		for (Competence c : daoCompetence.findAll()) {
			System.out.println(c.getId() + " - " + c.getNom() + " - " + c.getBonus());
		}
	}

	public void Soigner(int aventurierId) {
		Aventurier monAventurier = daoAventurier.findById(aventurierId).orElseThrow(RuntimeException::new);

		monAventurier.setEtat(EtatAventurier.EN_PLEINE_FORME.toString().toLowerCase());
		daoAventurier.save(monAventurier);

		System.out.println(monAventurier.getNom() + " a bien été soigné !!!");

	}
}
