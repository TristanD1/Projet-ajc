package Projet.Projet.DAO.Jpa;

import java.util.List;

import Projet.Projet.DAO.AbstractDaoJpa;
import Projet.Projet.DAO.IEquipementDao;
import model.Equipement;

public class EquipementDaoJpa extends AbstractDaoJpa<Equipement, Integer> implements IEquipementDao{

	@Override
	public List<Equipement> findAll() {
		List<Equipement> mesEquipements = em.createQuery("select e from Equipement e",Equipement.class).getResultList();
		return (mesEquipements);
	}

	@Override
	public Equipement findById(Integer id) {
		return (em.find(Equipement.class, id));
	}

}
