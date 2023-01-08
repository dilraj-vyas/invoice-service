package com.frostywhale.invoice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    private double total;

    private String status;
    private String date;
    private String paymentMethod;

    private double discount;

    private double subtotal;
    private double tax;
    private double discountPercentage;

    public Order(int id, Customer customer, List<OrderItem> items, String status, String date, String paymentMethod, double discount) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
//        this.subtotal = calculateSubTotal();
    }

//    private double calculateSubTotal() {
//        double sum = 0;
//        for (O item : items) {
//            sum += item.getPrice() * item.getQuantity();
//        }
//        return sum;
//    }


}
