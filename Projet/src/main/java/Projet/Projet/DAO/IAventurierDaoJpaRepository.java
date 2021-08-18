package Projet.Projet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet.Projet.model.Aventurier;

public interface IAventurierDaoJpaRepository extends JpaRepository<Aventurier, Integer> {
	
	

}
