package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aventurier")
public class Aventurier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVE_ID")
	private int id;

	@Column(name = "AVE_NOM", nullable = false)
	private String nom;

	@Column(name = "AVE_EXP")
	private int experience;
	
	@ManyToMany
	@JoinTable()
	private List<Competence> competences;

	@ManyToOne
	@JoinColumn(name = "AVE_QTE")
	private Quete quete;

	@OneToMany(mappedBy = "aventurier")
	private List<Equipement> equipements;

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
