package com.learn.springexample.entity.mock;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Data
//@Entity
@TableGenerator(name = "my_table")
public class TableGen {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table")
    private Long id;

    private String code;

}
