package Projet.Projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Projet.Projet.dao.IAventurierGuildeDaoJpaRepository;
import Projet.Projet.dao.IEquipementDaoJpaRepository;
import Projet.Projet.dao.IQueteDaoJpaRepository;
import Projet.Projet.dao.IRecompenseDaoJpaRepository;
import Projet.Projet.model.AventurierGuilde;
import Projet.Projet.model.Equipement;
import Projet.Projet.model.Quete;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class API {

	@Autowired
	private IQueteDaoJpaRepository daoQuete;

	@Autowired
	private IAventurierGuildeDaoJpaRepository daoAventurier;

	@Autowired
	private IEquipementDaoJpaRepository daoEquipement;

	@Autowired
	private IRecompenseDaoJpaRepository daoRecompense;

	@GetMapping("/associer-quete-aventurier")
	public void associerQueteAventurier(@RequestParam int idAventurier, @RequestParam int idQuete, Model model) {
		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
		Quete quete = daoQuete.findById(idQuete).get();

		// traitement
		try {
			if (quete.getId() == aventurier.getQuete().getId()) {
				aventurier.setQuete(null);
				daoAventurier.save(aventurier);
			} else {
				aventurier.setQuete(null);
				daoAventurier.save(aventurier);
				aventurier.setQuete(quete);
				daoAventurier.save(aventurier);
			}
		} catch (Exception e) {
			aventurier.setQuete(quete);
			daoAventurier.save(aventurier);
		}

		// retourner des infos ?

	}

	@GetMapping("/associer-equipement-aventurier")
	public void associerEquipementAventurier(@RequestParam int idAventurier, @RequestParam int idEquipement) {
		AventurierGuilde aventurier = daoAventurier.findById(idAventurier).get();
		Equipement equipement = daoEquipement.findById(idEquipement).get();

		List<Equipement> equipements = daoEquipement.findAll();
		
		for (Equipement eq : equipements) {
			try{
				if(eq.getAventurier().getId() == aventurier.getId()){
					eq.setAventurier(null);
					daoEquipement.save(eq);
			}
			}catch (Exception e1){
				
			}
		}
		try{
			if (aventurier.getId() == equipement.getAventurier().getId()){
				equipement.setAventurier(null);
				daoEquipement.save(equipement);
			}else{
				equipement.setAventurier(null);
				daoEquipement.save(equipement);
				equipement.setAventurier(aventurier);
				daoEquipement.save(equipement);
			}
		}catch (Exception e2){
			equipement.setAventurier(aventurier);
			daoEquipement.save(equipement);
			}
		
		
	}

}
