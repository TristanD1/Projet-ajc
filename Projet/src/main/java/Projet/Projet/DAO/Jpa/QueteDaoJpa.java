package Projet.Projet.DAO.Jpa;

import java.util.List;

import Projet.Projet.DAO.AbstractDaoJpa;

import Projet.Projet.DAO.IQueteDao;
import model.Quete;

public class QueteDaoJpa extends AbstractDaoJpa<Quete, Integer> implements IQueteDao{

	@Override
	public List<Quete> findAll() {
		List<Quete> mesQuetes = em.createQuery("select q from Quete q",Quete.class).getResultList();
		return (mesQuetes);
	}

	public Quete findById(Integer id) {
		return (em.find(Quete.class, id));
	}

}
