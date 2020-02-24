package com.learn.springexample.entity;



import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class CommonListeners<T extends CommonEntity> {

    @PrePersist
    private void prePersist(T e) {
        e.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate(T e) {
        e.setUpdatedDate(LocalDateTime.now());
    }

}
