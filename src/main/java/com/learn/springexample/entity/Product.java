package com.learn.springexample.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "products")
@SequenceGenerator(name = "products_seq")
@Table(indexes = {@Index(name = "products_idx_code_unique", columnList = "code", unique = true)})

public class Product {

    @Id
    @GeneratedValue(generator = "products_seq")
    private Long id;
    private String code;
    private String name;
    private String detail;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    private void prePersist() {
        setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate() {
        setUpdatedDate(LocalDateTime.now());
    }

    // Tips
    @Transient
    private String excludedField1;

    private transient String excludedField2;

    private static String excludedField3;


}
