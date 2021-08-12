package Projet.Projet.DAO;

import java.util.List;

public interface IDAO<T,K> {
	public List<T> findAll();
	public T findById(K id);
	
	public T insert(T entity);
	public T update(T entity);
	public T save(T entity);
	
	public void delete(T entity);
	public void deleteById(K id);
}
