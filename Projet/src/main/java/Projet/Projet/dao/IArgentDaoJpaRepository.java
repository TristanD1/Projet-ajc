package Projet.Projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet.Projet.model.Argent;

public interface IArgentDaoJpaRepository extends JpaRepository<Argent,Integer>{
    
}
