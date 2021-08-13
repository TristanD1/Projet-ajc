package Projet.Projet.DAO.Jpa;

import java.util.List;

import Projet.Projet.DAO.ICompetenceDao;
import model.Aventurier;
import model.Competence;

public class CompetenceDaoJpa extends AbstractDaoJpa<Competence, Integer> implements ICompetenceDao {

	@Override
	public List<Competence> findAll() {
		List<Competence> mesCompetences = em.createQuery("select c from Competence c", Competence.class)
				.getResultList();
		return (mesCompetences);
	}

	@Override
	public Competence findById(Integer id) {
		return (em.find(Competence.class, id));
	}

	@Override
	public List<Competence> findCommuneByAventurier(Aventurier aventurier) {

		return em
				.createQuery(
						"select c from Competence c inner join c.aventuriers a where a.id = ?1 and c.id in (select cq.id from Competence cq inner join cq.quetes q where q.id = ?2) ",
						Competence.class)
				.setParameter(1, aventurier.getId()).setParameter(2, aventurier.getQuete().getId()).getResultList();

	}

}
