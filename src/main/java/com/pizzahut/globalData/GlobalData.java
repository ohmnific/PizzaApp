package com.pizzahut.globalData;

import com.pizzahut.entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Pizza> cart = new ArrayList<>();
    public static double total(){
        double sum = 0;
        for(Pizza f : cart){
            sum += f.getPrice();
        }
        return sum;
    }
}
