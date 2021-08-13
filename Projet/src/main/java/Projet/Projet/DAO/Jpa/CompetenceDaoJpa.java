package Projet.Projet.DAO.Jpa;

import java.util.List;

import Projet.Projet.DAO.ICompetenceDao;
import model.Competence;

public class CompetenceDaoJpa extends AbstractDaoJpa<Competence, Integer> implements ICompetenceDao {

	@Override
	public List<Competence> findAll() {
		List<Competence> mesCompetences = em.createQuery("select c from Competence c",Competence.class).getResultList();
		return (mesCompetences);
	}

	@Override
	public Competence findById(Integer id) {
		return (em.find(Competence.class, id));
	}

}
