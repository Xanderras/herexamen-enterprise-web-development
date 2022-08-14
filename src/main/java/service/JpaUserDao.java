package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import domain.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class JpaUserDao implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}

}
