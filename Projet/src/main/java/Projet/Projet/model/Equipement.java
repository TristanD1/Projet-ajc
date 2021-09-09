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
	@Column(name="EQU_ID")
	private int id;

	@ManyToOne
	@JoinColumn(name="EQU_RECO")
	private Recompense recompense;

	@ManyToOne
	@JoinColumn(name = "EQU_AVENTURIER")
	private Aventurier aventurier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Recompense getRecompense() {
		return recompense;
	}

	public void setRecompense(Recompense recompense) {
		this.recompense = recompense;
	}

	public Aventurier getAventurier() {
		return aventurier;
	}

	public void setAventurier(Aventurier aventurier) {
		this.aventurier = aventurier;
	}
}
