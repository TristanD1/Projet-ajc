package Projet.Projet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Projet.Projet.DAO.*;
import Projet.Projet.DAO.Jpa.AbstractDaoJpa;
import Projet.Projet.DAO.Jpa.AventurierDaoJpa;
import model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	createAventurier("Toto", 1);
    	
    	AbstractDaoJpa.close();
    

    }
    
    public static void createAventurier(String nom, int exp){
    	
    	IAventurierDao daoAventurier = new AventurierDaoJpa();
    	Aventurier monAventurier = new Aventurier();
    	
    	monAventurier.setNom(nom);
    	monAventurier.setExperience(exp);
    	
    	daoAventurier.insert(monAventurier);
    	

    	
    	
    	
    }
}
