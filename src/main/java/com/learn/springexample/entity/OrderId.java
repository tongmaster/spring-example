package com.learn.springexample.entity;

/*
Composite class rules
    - public class
    - public no-arg constructor
    - Implement Serializable
    - Override equals , hashCode
    - Can be use @EmbeddedId / @IdClass
*/


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderId implements Serializable {

    private long id;
    private long productId;


}
