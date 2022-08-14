package com.springBoot.filmfestival;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/filmfestival";
	}
}
