package com.app.ams.model;

import org.springframework.stereotype.Component;

@Component
public class PercentageDiscount implements DiscountStrategy {
    public double calculate(double fee, double value){
        return fee - (fee * value / 100);
    }
}
