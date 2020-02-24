package com.learn.springexample.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Nationalized;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Data
@Entity(name = "orders")
@EqualsAndHashCode(callSuper = false)
@DynamicInsert
@DynamicUpdate
public class Order extends CommonEntity {

    @EmbeddedId
    private OrderId orderId;

    private int quantity;

    @Lob
    private String details;

    @Lob
    @Nationalized
    private String nationalDetails;

    @Lob
    private byte[] photos;

}

