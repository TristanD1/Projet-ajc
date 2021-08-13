package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Competence")
public class Competence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMP_ID")
	private int id;

	@Column(name = "COMP_NOM")
	private String nom;

	@Column(name = "COMP_BONUS")
	private int bonus;

	@ManyToMany(mappedBy = "competences")
	private List<Aventurier> aventuriers;

	@ManyToMany(mappedBy = "competences")
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

	public List<Aventurier> getAventuriers() {
		return aventuriers;
	}

	public void setAventuriers(List<Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}

	public List<Quete> getQuetes() {
		return quetes;
	}

	public void setQuetes(List<Quete> quetes) {
		this.quetes = quetes;
	}

}
