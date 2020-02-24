package com.learn.springexample.entity;



import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;

@Data
@Entity(name = "orders")
@ExcludeSuperclassListeners
public class Order extends CommonEntity {

    @EmbeddedId
    private OrderId orderId;
    private int quantity;


}







