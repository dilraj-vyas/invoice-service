package com.frostywhale.invoice.model;

import java.util.List;

import com.frostywhale.invoice.entity.Customer;
import com.frostywhale.invoice.entity.OrderItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Invoice {
    private int id;
    private Customer customer;
    private List<OrderItem> items;
    private double total;

    private double discount;

    private double subtotal;
    private double tax;
    private double discountPercentage;

    private String date;


}
