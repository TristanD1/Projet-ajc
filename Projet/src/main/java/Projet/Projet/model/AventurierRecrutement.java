package Projet.Projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aventurierRecrutement")
public class AventurierRecrutement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVE_ID")
	private int id;

	@Column(name = "AVE_NOM", nullable = false)
	private String nom;

	@Column(name = "AVE_EXP")
	private int experience;

	@Column(name = "AVE_COUT")
	private int cout;

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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

}
