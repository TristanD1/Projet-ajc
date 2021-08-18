package Projet.Projet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet.Projet.model.Catalogue;

public interface ICatalogueDaoJpaRepository extends JpaRepository<Catalogue, Integer> {

}
