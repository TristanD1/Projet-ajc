package Projet.Projet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Projet.Projet.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Traitement traitement = myContext.getBean(Traitement.class);

		// traitement.RecuperationAventurier();
		// traitement.RecuperationEquipement();
		// traitement.RecuperationCompetence();
		// traitement.RecuperationQuete();

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

		// traitement.AssocierEquipementAventurier(2, 1);
		// traitement.AssocierEquipementAventurier(1, 2);
		// traitement.AssocierEquipementAventurier(3, 2);
		//
		// traitement.AssocierAventurierCompetence(1, 2);
		// traitement.AssocierAventurierCompetence(1, 3);
		// traitement.AssocierAventurierCompetence(2, 1);
		// traitement.AssocierAventurierCompetence(2, 3);
		//
		// traitement.AssocierQueteCompetence(5, 1);
		// traitement.AssocierQueteCompetence(5, 3);

		traitement.AssocierAventurierQuete(1, 5);
		traitement.AssocierAventurierQuete(2, 5);

		traitement.EnvoyerEnMission(5);

		myContext.close();
	}

}
