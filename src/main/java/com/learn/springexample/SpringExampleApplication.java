package com.learn.springexample;

import com.learn.springexample.entity.Product;
import com.learn.springexample.repo.OrderRepository;
import com.learn.springexample.repo.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@Log4j2
@EnableAsync
@SpringBootApplication
public class SpringExampleApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	OrderRepository orderRepo;

	public static void main(String[] args) {
		System.err.close();
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Product product = new Product();
		product.setCode("P001");
		product.setName("Coffee");
		product.setStatus(Product.Status.APPROVED);
		product.getAliasNames().add("Java");
		product.getAliasNames().add("Cuppa");
		product.getAliasNames().add("Caffeine");
        product = productRepo.save(product);
		log.debug(product);


//        Product product2 = new Product();
//        product2.setCode("1002");
//        product2.setName("Milk");
//        product2.setStatus(Product.Status.PENDING);
//        productRepo.save(product2);
//
//        Product product3 = new Product();
//        product3.setCode("1003");
//        product3.setName("Beer");
//        product3.setStatus(Product.Status.NOT_APPROVED);
//        productRepo.save(product3);
//
//        Product product4 = new Product();
//        product4.setCode("1004");
//        product4.setName("Soda");
//        productRepo.save(product4);

//        productRepo.findAll().stream().forEach(p->{
//            System.out.println(p.getName()+"\tStatus :\t"+p.getStatus());
//        });
	}




}
