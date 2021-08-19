package Projet.Projet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recompense")
public class Recompense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECO_ID")
	private int id;

	@Column(name = "RECO_NOM")
	private String nom;

	@Column(name = "RECO_BONUS")
	private int bonus;

	@ManyToMany(mappedBy = "recompenses")
	private List<Quete> quetes;

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

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public List<Quete> getQuetes() {
		return quetes;
	}

	public void setQuetes(List<Quete> quetes) {
		this.quetes = quetes;
	}
}
