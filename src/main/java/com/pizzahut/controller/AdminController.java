package com.pizzahut.controller;

import com.pizzahut.repository.CustomerRepository;
import com.pizzahut.repository.PizzaRepository;
import com.pizzahut.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

     @Autowired
     PizzaRepository pizzaRepository;
     @Autowired
     CustomerRepository customerRepository;

     @GetMapping("/dashboard")
     public String adminDashboard(){
          return "dashboard";
     }
     @GetMapping("/pizza")
     public String adminPizza(Model model){
          model.addAttribute("pizzas", pizzaRepository.findAll());
          return "pizzaDashboard";
     }
     @PostMapping("/pizza/add")
     public String adminPostPizza(@ModelAttribute("pizza") Pizza pizza){
          pizzaRepository.save(pizza);
          return  "redirect:/admin/pizza";
     }
     @GetMapping("/pizza/delete/{id}")
     public String delete(@PathVariable("id") int id){
          pizzaRepository.deleteById(id);
          return "redirect:/admin/pizza";
     }
     @PutMapping("/pizza/update/{id}")
     public String update(@PathVariable int id, Model model){
          Optional<Pizza> pizza = pizzaRepository.findById(id);
          model.addAttribute("pizza",pizza.get());
          return "redirect:/admin/pizza";
     }
     @GetMapping("/customer")
     public String adminCustomer(Model model){
          model.addAttribute("customer", customerRepository.findAll());
          return "pizzaDashboard";
     }
}
