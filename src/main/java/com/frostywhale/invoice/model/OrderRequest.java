package com.frostywhale.invoice.model;

import java.util.List;

import com.frostywhale.invoice.entity.Customer;
import com.frostywhale.invoice.entity.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderRequest {

    private Customer customer;

    private List<OrderItem> items;

    private double total;

    private String status;
    private String date;
    private String paymentMethod;

    private double discount;

    private double subtotal;
    private double tax;
    private double discountPercentage;

    public double getSubtotal() {
        return calculateSubTotal();
    }

    private double calculateSubTotal() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.getProduct().getPrice() * item.getQuantity();
        }
        return sum;
    }

}
