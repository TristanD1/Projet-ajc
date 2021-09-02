package Projet.Projet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Projet.Projet.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Traitement traitement = myContext.getBean(Traitement.class);

<<<<<<< HEAD
		traitement.InitDatabase();
=======
		// TODO LISTE
		// construire les association catalogue <-> equipement

		 traitement.InitDatabase();

		//traitement.AssocierEquipementAventurier(1, 1);

		// traitement.AssocierAventurierCompetence(1, 2);
		// traitement.AssocierAventurierCompetence(1, 3);
		// traitement.AssocierAventurierCompetence(2, 1);
		// traitement.AssocierAventurierCompetence(2, 3);

		// traitement.AssocierQueteCompetence(5, 1);
		// traitement.AssocierQueteCompetence(5, 3);

		// traitement.AssocierQueteRecompense(1, 2);
		
//		traitement.DissocierAventurierCompetence(1, 3);
//		
//		traitement.AssocierAventurierQuete(1, 1);
//		traitement.AssocierAventurierQuete(2, 1);
//		traitement.AssocierAventurierQuete(3, 1);
//
//		traitement.EnvoyerEnMission(1);
>>>>>>> 9ef88af61d990ce7cb6e76bf62fee2aef2ed2a19

		myContext.close();

	}

}
