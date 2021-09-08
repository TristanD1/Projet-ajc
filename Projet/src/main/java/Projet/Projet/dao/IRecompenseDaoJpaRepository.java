package Projet.Projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Projet.Projet.model.Recompense;

public interface IRecompenseDaoJpaRepository extends JpaRepository<Recompense, Integer> {
    public List<Recompense> findByQuete();
}
