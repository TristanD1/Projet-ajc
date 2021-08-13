package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "quete")
public class Quete {

	@Id

	@Column(name = "QTE_ID")
	private int id;

	@Column(name = "QTE_INTITULE")
	private String intitule;

	@Column(name = "QTE_ETAT")
	private String Etat;

//	@Column(name = "QTE_RECOMPENSE")
//	private Equipement recompense;

	@Column(name = "QTE_PROBA_REUSSITE", precision = 10, scale = 2)
	private BigDecimal probaReussite;

	@OneToMany(mappedBy = "quete")
	private List<Aventurier> aventuriers;

	public Quete() {
		super();
	}

	public Quete(String intitule, String etat, BigDecimal probaReussite) {
		super();
		this.intitule = intitule;
		Etat = etat;
		this.probaReussite = probaReussite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

//	public Equipement getRecompense() {
//		return recompense;
//	}
//
//	public void setRecompense(Equipement recompense) {
//		this.recompense = recompense;
//	}

	public BigDecimal getProbaReussite() {
		return probaReussite;
	}

	public void setProbaReussite(BigDecimal probaReussite) {
		this.probaReussite = probaReussite;
	}

	public List<Aventurier> getAventuriers() {
		return aventuriers;
	}

	public void setAventuriers(List<Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}

	
	
	

}
