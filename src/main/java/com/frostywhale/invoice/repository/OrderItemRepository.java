package com.frostywhale.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frostywhale.invoice.entity.OrderItem;
import com.frostywhale.invoice.entity.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
