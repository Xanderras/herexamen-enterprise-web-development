package service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Film;

@Repository("filmDao")
public class JpaFilmDao extends JpaGenerischeDao<Film> implements FilmDao {
	
	public JpaFilmDao(Class<Film> type) {
		super(type);
	}
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<String> getListOfFilms() {
		return findAll().stream().map(f -> f.getNaam()).sorted().collect(Collectors.toList());
	}

}
