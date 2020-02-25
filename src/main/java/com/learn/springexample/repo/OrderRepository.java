package com.learn.springexample.repo;

import com.learn.springexample.entity.Order;
import com.learn.springexample.entity.OrderId;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CommonRepository<Order, OrderId> {

}


