package com.springBoot.filmfestival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.FilmDao;
import service.UserDao;

@Controller
@RequestMapping("/filmfestival")
public class FilmfestivalController {
	
	@Autowired
	FilmDao filmDao;

	@GetMapping
	public String showHomePage(Model model) {
		model.addAttribute("filmList", filmDao.getListOfFilms());
		return "homeScreen";
	}
	
}
