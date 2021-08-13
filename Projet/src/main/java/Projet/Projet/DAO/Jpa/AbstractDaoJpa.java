package Projet.Projet.DAO.Jpa;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Projet.Projet.DAO.IDAO;

public abstract class AbstractDaoJpa<T,K> implements IDAO<T, K> {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetUnit");
	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}
	
	public T insert (T entity){
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return(entity);
	}
	
	public T update (T entity){
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return(entity);
	}
	
	public void delete (T entity){
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}
	
	public T save(T entity) {
		Integer entityId = 0;
		try {
			Method method = entity.getClass().getMethod("getId");
			Object result = method.invoke(entity);
			entityId = (Integer) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (entityId>0){
			return this.update(entity);
		}
		else {
			return this.insert(entity);
		}
	}
	
	public abstract T findById(K id);
	
	public void deleteById(K id){
		this.delete(this.findById(id));
	}
}
