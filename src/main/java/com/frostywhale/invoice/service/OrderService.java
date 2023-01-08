package com.frostywhale.invoice.service;

import java.util.List;

import com.frostywhale.invoice.entity.Order;

public interface OrderService {

    public Order save(Order order);

    public Order getById(int id);


    public List<Order> getAll();
}
