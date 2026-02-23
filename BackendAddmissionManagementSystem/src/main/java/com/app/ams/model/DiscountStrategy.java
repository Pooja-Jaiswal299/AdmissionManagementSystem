package com.app.ams.model;

public interface DiscountStrategy {
    double calculate(double fee, double value);
}
