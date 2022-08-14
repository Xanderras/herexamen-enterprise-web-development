package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import domain.Film;

public class DatabankOpvullen implements CommandLineRunner {
	@Autowired
	private GenerischeDao<Film> generischeDaoFilm;
	
	@Override
	public void run(String... args) throws Exception{
		Film film1 = new Film("AB321", "The Greatest Showman",new String[] {"Michael Gracey"}, 40, 200);
		Film film2 = new Film("FR111", "Frozen",new String[] {"Chris Buck", "Jennifer Lee"}, 40, 200);
		Film film3 = new Film("MI721", "Minions: The Rise of Gru",new String[] {"Serio Pablos"}, 40, 200);
		Film film4 = new Film("BE513", "Beast",new String[] {"Baltasar Kormákur"}, 40, 200);
		Film film5 = new Film("BT516", "Bullet Train",new String[] {"David Leitch"}, 40, 200);
		
		List<Film> films = Arrays.asList(film1, film2, film3, film4, film5);
		
		generischeDaoFilm.insertAll(films);
		
	}
	
	
}
