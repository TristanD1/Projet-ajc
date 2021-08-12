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
@Table(name = "equipement")
public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "EQU_NOM")
	private String nom;

	@ManyToMany(mappedBy = "equipements")
	private List<Aventurier> aventuriers;

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

	public List<Aventurier> getAventuriers() {
		return aventuriers;
	}

	public void setAventuriers(List<Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}

	public Equipement() {

	}
}
