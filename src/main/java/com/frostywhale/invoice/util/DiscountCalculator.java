package com.frostywhale.invoice.util;

import org.springframework.stereotype.Component;

import com.frostywhale.invoice.entity.Order;

public class DiscountCalculator {

    private static double discountRate;

    public DiscountCalculator(double discountRate) {
        this.discountRate = discountRate;
    }

    public static double calculateDiscount(Order order) {
        return order.getSubtotal() * order.getDiscountPercentage();
    }
}
