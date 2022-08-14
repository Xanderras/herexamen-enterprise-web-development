package com.springBoot.filmfestival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import antlr.debug.GuessingEvent;
import domain.Film;
import service.DatabankOpvullen;
import service.FilmDao;
import service.JpaFilmDao;

@SpringBootApplication
public class FilmfestivalApplication implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("resources/img/");
	}

	public static void main(String[] args) {
		SpringApplication.run(FilmfestivalApplication.class, args);
	}
	
	@Bean
	public FilmDao filmDao() {
		return new JpaFilmDao(Film.class);
	}
	
	@Bean 
	public DatabankOpvullen databankOpvulling() {
		return new DatabankOpvullen();
	}

}
