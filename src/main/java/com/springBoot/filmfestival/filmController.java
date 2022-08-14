package com.springBoot.filmfestival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.FilmDao;

@Controller
public class filmController {
	@Autowired
	private FilmDao filmDao;
	
	@GetMapping(value="/film")
    public String listFilm(Model model) {
         model.addAttribute("filmList", filmDao.getListOfFilms());
         return "nominatedFilms";
    }

}
