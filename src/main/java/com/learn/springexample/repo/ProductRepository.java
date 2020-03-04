package com.learn.springexample.repo;


import com.learn.springexample.dto.Pojo;
import com.learn.springexample.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends CommonRepository<Product, Long> {


    Optional<List<Product>> fetchDetailNotNull();

    Optional<List<Product>> fetchDetailLengthGreaterThan2();

    @Query(nativeQuery = true)
    List<Pojo> customFetchProductToPojo();

}


