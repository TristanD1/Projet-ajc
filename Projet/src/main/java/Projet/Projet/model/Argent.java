package Projet.Projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="argent")
public class Argent {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARGENT_ID")
    private int id;
    
    @Column(name = "ARGENT_SOMME")
    private Integer somme = 5000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSomme() {
        return somme;
    }

    public void setSomme(Integer somme) {
        this.somme = somme;
    }
    
    
}
