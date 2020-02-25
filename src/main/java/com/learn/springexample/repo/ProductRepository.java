package com.learn.springexample.repo;


import com.learn.springexample.entity.Product;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CommonRepository<Product, Long> {

}


