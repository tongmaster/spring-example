package com.learn.springexample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity(name = "products")
@SequenceGenerator(name = "products_seq")
@Table(indexes = {
        @Index(name = "products_idx_code_unique", columnList = "code", unique = true),
        @Index(name = "products_idx_status", columnList = "status")
})
public class Product extends CommonEntity{

    @Id
    @GeneratedValue(generator = "products_seq")
    private long id;
    private String code;
    private String name;
    private String detail;

    @Enumerated(EnumType.STRING)
    Status status;

    public enum Status {
        APPROVED,
        NOT_APPROVED,
        PENDING
    }






}


