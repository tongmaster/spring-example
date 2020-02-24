package com.learn.springexample.entity;



import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity(name = "orders")
public class Order {

    //  IdClass
    //  EmbeddedId

//    @Id
//    @Column(name = "o_id")
//    private long id;
//
//    @Id
//    @Column(name = "p_id")
//    private long productId;

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id",column = @Column(name = "od_id")),
            @AttributeOverride(name = "productId",column = @Column(name = "pd_id"))
    })
    private OrderId orderId;

    private int quantity;

}
