package Projet.Projet.DAO;

import java.util.List;

import Projet.Projet.model.Aventurier;
import Projet.Projet.model.Competence;

public interface ICompetenceDao extends IDAO<Competence, Integer>{
		public List<Competence> findCommuneByAventurier(Aventurier aventurier);
}
