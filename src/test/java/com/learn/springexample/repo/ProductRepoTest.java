package com.learn.springexample.repo;

import com.learn.springexample.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepoTest {


    @Autowired private ProductRepository userRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        Product product = new Product();
        product.setId(1);
        Optional<Product> actual = userRepository.findById(product.getId());
        System.out.println(actual.get().toString());
        Assert.assertNotNull(actual.get().getId());
    }


}
