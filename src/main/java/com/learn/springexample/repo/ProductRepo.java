package com.learn.springexample.repo;


import com.learn.springexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {


    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "Update com.learn.springexample.entity.Product p set p.name = ?1 where p.code = ?2 ")
    int jpqlUpdate(String name, String code);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "update products set name = ?1 where code = ?2 ", nativeQuery = true)
    int sqlUpdate(String name, String code);

}
