package com.learn.springexample.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;


@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(value = CommonListeners.class)
public abstract class CommonEntity {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Version
    private int version;

}


