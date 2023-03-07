package com.pizzahut.controller;

import com.pizzahut.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class HomeController {
	@Autowired
	PizzaRepository pizzaRepository;
	@GetMapping({"/home","/"})
	public String homeController(Model model) {
		model.addAttribute("pizzas",pizzaRepository.findAll());
		System.out.println("Home Controller working");
		return "index";
	}

}
