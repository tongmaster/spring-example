package com.learn.springexample.dto;

import lombok.Data;

@Data
public class Pojo {
    private long id;
    private String codeAndName;
    private String detail;

    public Pojo(long id, String codeAndName, String detail) {
        this.id = id;
        this.codeAndName = codeAndName;
        this.detail = detail;
    }

}
