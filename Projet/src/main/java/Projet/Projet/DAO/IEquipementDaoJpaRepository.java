package Projet.Projet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet.Projet.model.Equipement;

public interface IEquipementDaoJpaRepository extends JpaRepository<Equipement, Integer> {

}
