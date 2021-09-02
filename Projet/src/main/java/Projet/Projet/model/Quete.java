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

	@Column(name = "QTE_DIFFICULTE", precision = 10, scale = 2)
	private int difficulte;

	@OneToMany(mappedBy = "quete")
	private List<AventurierGuilde> aventuriers;
	
	@ManyToMany
	@JoinTable(name = "QTE_RECO", joinColumns = @JoinColumn(name = "IDQTE", referencedColumnName = "QTE_ID") , inverseJoinColumns = @JoinColumn(name = "IDRECO", referencedColumnName = "RECO_ID") )
	private List<Recompense> recompenses;

	public List<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(List<Recompense> recompenses) {
		this.recompenses = recompenses;
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

	public List<AventurierGuilde> getAventuriers() {
		return aventuriers;
	}

	public void setAventuriers(List<AventurierGuilde> aventuriers) {
		this.aventuriers = aventuriers;
	}

//	public List<Equipement> getRecompense() {
//		return recompense;
//	}
//
//	public void setRecompense(List<Equipement> recompense) {
//		this.recompense = recompense;
//	}

}
