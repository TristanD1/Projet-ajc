package Projet.Projet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Projet.Projet.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Traitement traitement = myContext.getBean(Traitement.class);
		
		// TODO LISTE
		// try catch pour les compétences, sysout("compétence déjà attribuée")
	    // construire les association catalogue <-> equipement

		traitement.InitDatabase();

		traitement.AssocierEquipementAventurier(2, 1);
		traitement.AssocierEquipementAventurier(1, 2);
		traitement.AssocierEquipementAventurier(3, 2);

		traitement.AssocierAventurierCompetence(1, 2);
		traitement.AssocierAventurierCompetence(1, 3);
		traitement.AssocierAventurierCompetence(2, 1);
		traitement.AssocierAventurierCompetence(2, 3);

		traitement.AssocierQueteCompetence(5, 1);
		traitement.AssocierQueteCompetence(5, 3);

		traitement.AssocierAventurierQuete(1, 5);
		traitement.AssocierAventurierQuete(2, 5);

		traitement.EnvoyerEnMission(5);

		traitement.Soigner(1);

		myContext.close();
	}

}
