package com.learn.springexample.repo;


import com.learn.springexample.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface ProductRepository extends CommonRepository<Product, Long> {

    Optional<Collection<Product>> findAllByStatus(Product.Status status);

    Optional<Collection<Product>> findAllByStatusOrderByIdDesc(Product.Status status);

    Optional<Collection<Product>> findAllByNameContaining(String name);

    Optional<Collection<Product>> findAllByNameContainingIgnoreCase(String name);

    Optional<Collection<Product>> findAllByCodeContainingAndNameEndingWith(String code, String name);

    Optional<Collection<Product>> findAllByCodeOrCodeAndName(String whereCode, String orCode, String andName);

}


