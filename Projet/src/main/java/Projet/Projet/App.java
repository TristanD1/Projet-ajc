package Projet.Projet;

public class App {
	public static void main(String[] args) {
		Traitement traitement = new Traitement();
		
		traitement.RecuperationAventurier();
		traitement.RecuperationEquipement();
		traitement.RecuperationCompetence();
		traitement.RecuperationQuete();

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

}
