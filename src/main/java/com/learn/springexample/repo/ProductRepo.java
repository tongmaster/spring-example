package com.learn.springexample.repo;


import com.learn.springexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {

}

