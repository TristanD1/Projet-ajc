package Projet.Projet.DAO.Jpa;

import java.util.List;

import Projet.Projet.DAO.Jpa.AbstractDaoJpa;
import Projet.Projet.DAO.IAventurierDao;
import model.Aventurier;

public class AventurierDaoJpa extends AbstractDaoJpa<Aventurier, Integer> implements IAventurierDao{

	public List<Aventurier> findAll() {
		List<Aventurier> mesAventuriers = em.createQuery("select a from Aventurier a",Aventurier.class).getResultList();
		return (mesAventuriers);
	}

	public Aventurier findById(Integer id) {
		return (em.find(Aventurier.class, id));
	}
}
