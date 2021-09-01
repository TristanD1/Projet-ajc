package Projet.Projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Projet.Projet.model.Competence;

public interface ICompetenceDaoJpaRepository extends JpaRepository<Competence, Integer> {
	@Query("select c from Competence c inner join c.aventuriers a where a.id = ?1 and c.id in (select cq.id from Competence cq inner join cq.quetes q where q.id = ?2) ")
	public List<Competence> findCommuneByAventurier(int aventurierId, int queteId);

}
