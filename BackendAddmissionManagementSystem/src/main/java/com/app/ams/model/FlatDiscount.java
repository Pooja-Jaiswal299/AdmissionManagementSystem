package com.app.ams.model;

import org.springframework.stereotype.Component;

@Component
public class FlatDiscount implements DiscountStrategy {
    public double calculate(double fee, double value){
        return fee - value;
    }
}
