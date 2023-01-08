package com.frostywhale.invoice.util;

import com.frostywhale.invoice.entity.Order;

public class TaxCalculator {

    private static double taxRate = .12;

    public TaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public static double calculateTax(Order order) {
        return order.getSubtotal() * taxRate;
    }
}
