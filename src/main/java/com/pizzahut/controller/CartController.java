
package com.pizzahut.controller;


import com.pizzahut.globalData.GlobalData;
import com.pizzahut.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
   @Autowired
   PizzaRepository pizzaRepository;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        GlobalData.cart.add(pizzaRepository.findById(id).get());
        return "redirect:/home#menu";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("total", GlobalData.total());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/delete/{index}")
    public String cartRemove(@PathVariable int index) throws ResourceNotFoundException {

        GlobalData.cart.remove(index);

            return "redirect:/cart";
        }
}

