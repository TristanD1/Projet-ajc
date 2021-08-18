package Projet.Projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipement")
public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "EQU_NOM")
	private String nom;

	@Column(name = "EQU_BONUS")
	private int bonus;

	@ManyToOne
	@JoinColumn(name = "EQU_AVENTURIER")
	private Aventurier aventurier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int attaque) {
		this.bonus = attaque;
	}

	public Aventurier getAventurier() {
		return aventurier;
	}

	public void setAventurier(Aventurier aventurier) {
		this.aventurier = aventurier;
	}

	public Equipement() {

	}
}
