package com.learn.springexample.converter;


import com.learn.springexample.entity.Product;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;


@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<Product.Status, String> {

    @Override
    public String convertToDatabaseColumn(Product.Status status) {
        return Objects.isNull(status) ? null : status.getCode();
    }

    @Override
    public Product.Status convertToEntityAttribute(String code) {
        return Objects.isNull(code) ? null : Product.Status.codeToStatus(code);
    }

}
