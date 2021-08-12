package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "EQU_NOM")
	private String nom;

	@ManyToMany(mappedBy = "equipements")
	private List<Aventurier> aventuriers;
}
