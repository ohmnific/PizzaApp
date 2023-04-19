package com.pizzahut.controller;

import com.pizzahut.entity.Customer;
import com.pizzahut.entity.Orders;
import com.pizzahut.entity.Pizza;
import com.pizzahut.repository.CustomerRepository;
import com.pizzahut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import static com.pizzahut.globalData.GlobalData.cart;
import static com.pizzahut.globalData.GlobalData.total;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;


    @PostMapping("cart/customer/add")
    public String PostCustomer(Customer customer) {
        customerRepository.save(customer);
        System.out.println(customer.getId());
        Orders orders = new Orders();
        orders.setCustomer_id(customer.getId());
        String s="";
        for(Pizza i:cart){
            s+=Integer.toString(i.getId());
            s+=",";
        }
        orders.setPizza_ids(s);
        orders.setOrder_total(total());
        orderRepository.save(orders);
        cart.clear();
        return "orderSuccessful";
    }
}
