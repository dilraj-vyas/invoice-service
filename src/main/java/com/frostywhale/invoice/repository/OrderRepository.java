package com.frostywhale.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frostywhale.invoice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


}
