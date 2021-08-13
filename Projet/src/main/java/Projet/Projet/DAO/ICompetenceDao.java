package Projet.Projet.DAO;

import java.util.List;

import model.Aventurier;
import model.Competence;

public interface ICompetenceDao extends IDAO<Competence, Integer>{
		public List<Competence> findCommuneByAventurier(Aventurier aventurier);
}
