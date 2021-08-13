package Projet.Projet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetUnit");
    	EntityManager em = emf.createEntityManager();
    	
    	em.close();
    	emf.close();
    }
}
