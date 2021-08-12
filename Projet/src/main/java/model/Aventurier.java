package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Aventurier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVE=ID")
	private int id;

	@Column(name = "AVE_NOM", nullable = false)
	private String nom;

	@Column(name = "AVE_EXP")
	private int experience;

	@ManyToOne
	@Column(name = "AVE_QTE")
	private Quete quete;

	@ManyToMany
	@JoinTable()
	private List<Equipement> equipements;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Quete getQuete() {
		return quete;
	}

	public void setQuete(Quete quete) {
		this.quete = quete;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Aventurier() {

	}
}
