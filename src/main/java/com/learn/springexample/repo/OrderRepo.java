package com.learn.springexample.repo;

import com.learn.springexample.entity.Order;
import com.learn.springexample.entity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepo extends JpaRepository<Order, OrderId> {
}

