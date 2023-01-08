package com.frostywhale.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frostywhale.invoice.entity.Order;
import com.frostywhale.invoice.model.OrderRequest;
import com.frostywhale.invoice.service.OrderService;

@RestController
@RequestMapping("frosty-whale/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody OrderRequest orderRequest) {
        Order order = Order.builder().customer(orderRequest.getCustomer()).items(orderRequest.getItems()).subtotal(orderRequest.getSubtotal())
            .status(orderRequest.getStatus()).paymentMethod(orderRequest.getPaymentMethod()).discountPercentage(orderRequest.getDiscountPercentage())
            .date(orderRequest.getDate()).build();
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
