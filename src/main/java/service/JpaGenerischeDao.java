package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


public class JpaGenerischeDao<T> implements GenerischeDao<T> {

	private Class<T> type;
	protected EntityManager em;
	
	public JpaGenerischeDao(Class<T> type) {
		super();
		this.type = type;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		return this.em.createQuery("select entity from " + this.type.getName() + " entity").getResultList();
	}

	@Transactional
	@Override
	public T update(T object) {
		return em.merge(object);
	}

	@Transactional(readOnly = true)
	@Override
	public T get(Long id) {
		T entity = this.em.find(this.type, id);
		return entity;
	}

	@Transactional
	@Override
	public void delete(T object) {
		em.remove(em.merge(object));
		
	}

	@Transactional
	@Override
	public void insert(T object) {
		em.persist(object);
		
	}
	
	@Transactional
	@Override
	public void insertAll(List<T> object) {
		for(T o : object) {
			em.persist(o);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public boolean exists(Long id) {
		T entity = this.em.find(this.type, id);
		return entity != null;
	}

}
