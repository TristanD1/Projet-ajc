package model;

import java.util.List;

public class Aventurier {
	private String nom;
	private int experience;
	private Quete quete;
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
