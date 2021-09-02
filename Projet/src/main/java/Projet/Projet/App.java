package Projet.Projet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Projet.Projet.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Traitement traitement = myContext.getBean(Traitement.class);

		traitement.InitDatabase();

		myContext.close();

	}

}
