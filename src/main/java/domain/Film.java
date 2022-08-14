package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Film")
public class Film implements Serializable {
	@Id
	private String filmcode;
	private String naam;
	private String[] regisseurs;
	private int filmcode1;
	private int filmcode2;
	
	protected Film() {
	}
	
	public Film(String filmcode, String naam, String[] regisseurs, int filmcode1, int filmcode2) {
		setFilmcode(filmcode);
		setNaam(naam);
		setRegisseurs(regisseurs);
		setFilmcode1(filmcode1);
		setFilmcode2(filmcode2);
	}

	public void setFilmcode(String filmcode) {
		this.filmcode = filmcode;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String[] getRegisseurs() {
		return regisseurs;
	}

	public void setRegisseurs(String[] regisseurs) {
		this.regisseurs = regisseurs;
	}

	public void setFilmcode1(int filmcode1) {
		this.filmcode1 = filmcode1;
	}

	public void setFilmcode2(int filmcode2) {
		this.filmcode2 = filmcode2;
	}
	
	
}
