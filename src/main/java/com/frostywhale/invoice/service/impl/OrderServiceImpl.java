package com.frostywhale.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frostywhale.invoice.entity.Order;
import com.frostywhale.invoice.entity.OrderItem;
import com.frostywhale.invoice.entity.Product;
import com.frostywhale.invoice.repository.CustomerRepository;
import com.frostywhale.invoice.repository.OrderItemRepository;
import com.frostywhale.invoice.repository.OrderRepository;
import com.frostywhale.invoice.repository.ProductRepository;
import com.frostywhale.invoice.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {


    ProductRepository productRepository;
    CustomerRepository customerRepository;
    OrderItemRepository orderItemRepository;

    private OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository,
                            OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {

        customerRepository.save(order.getCustomer());

        List<OrderItem> items = order.getItems();
        for (OrderItem item : items) {
            Product product = item.getProduct();
            productRepository.save(product);
            item.setOrder(order);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
