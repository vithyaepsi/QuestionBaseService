package com.vithya.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vithya.questions.model.People;
import com.vithya.service.PeopleServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private PeopleServiceImpl peopleService;
	
	@RequestMapping("/")
	public String trucmachin() {
		//	Génération d'un People
		People p = new People("Roger", "LELAPIN", 33);
		
		//	Sauvegarde du People
		peopleService.save(p);
		
		//	Tentative de récupération du People
		People p2 = peopleService.findByFirstnameAndAge("Roger", 33);
		
		
		return "/masuperpage";
	}
}
