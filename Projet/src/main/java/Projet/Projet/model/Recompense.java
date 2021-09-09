package Projet.Projet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@Column(name="RECO_IMG")
	private String image;

	@Column(name="RECO_DESCR")
	private String description;
	
	@OneToMany(mappedBy="recompense", fetch=FetchType.EAGER)
	private List<Equipement> equipements;

	@Column(name="RECO_SELL")
	private Boolean isSellable = false;

	@ManyToMany(mappedBy = "recompenses")
	private List<Quete> quetes;

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
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

	public Boolean isSellable(){
		for (Equipement equipement : equipements) {
			if (equipement.getAventurier()==null){
				isSellable=true;
			}
		}
		return isSellable;
	}
}
