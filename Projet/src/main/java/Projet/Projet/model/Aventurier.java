package Projet.Projet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
	@JoinTable(name = "AVE_COMP", joinColumns = @JoinColumn(name = "IDAVE", referencedColumnName = "AVE_ID"), inverseJoinColumns = @JoinColumn(name = "IDCOMP", referencedColumnName = "COMP_ID"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"IDAVE", "IDCOMP" }))
	private List<Competence> competences;

	@ManyToOne
	@JoinColumn(name = "AVE_QTE")
	private Quete quete;

	@OneToMany(mappedBy = "aventurier", fetch = FetchType.EAGER)
	private List<Equipement> equipements;

	@Column(name = "AVE_ETAT")
	private String etat;

	@Column(name = "AVE_RECRU", nullable = false)
	private boolean isRecru;

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

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isRecru() {
		return isRecru;
	}

	public void setRecru(boolean isRecru) {
		this.isRecru = isRecru;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

}
