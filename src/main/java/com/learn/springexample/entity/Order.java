package com.learn.springexample.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Nationalized;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Data
@Entity(name = "orders")
@EqualsAndHashCode(callSuper = false)
public class Order extends CommonEntity {

    @EmbeddedId
    private OrderId orderId;

    private int quantity;

    @Lob
    private String details;             // CLOB

    @Lob
    @Nationalized                       // NCLOB
    private String nationalDetails;

    @Lob                                // BLOB
    private byte[] photos;

}


//    @Lob                            // clob
//    @Nationalized                   // nclob
//    private String details;
//
//    @Lob                            // blob
//    private byte[] photo;








