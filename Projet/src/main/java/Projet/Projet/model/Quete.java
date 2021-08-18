package Projet.Projet.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "quete")
public class Quete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QTE_ID")
	private int id;

	@Column(name = "QTE_INTITULE")
	private String intitule;

	@Column(name = "QTE_ETAT")
	private String etat;

	@ManyToMany
	@JoinTable(name = "QTE_COMP", joinColumns = @JoinColumn(name = "IDQTE", referencedColumnName = "QTE_ID") , inverseJoinColumns = @JoinColumn(name = "IDCOMP", referencedColumnName = "COMP_ID") , uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDQTE", "IDCOMP" }) )
	private List<Competence> competences;

	// @Column(name = "QTE_RECOMPENSE")
	// private Equipement recompense;

	@Column(name = "QTE_DIFFICULTE", precision = 10, scale = 2)
	private int difficulte;

	@OneToMany(mappedBy = "quete")
	private List<Aventurier> aventuriers;

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
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	public List<Aventurier> getAventuriers() {
		return aventuriers;
	}

	public void setAventuriers(List<Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}

}
