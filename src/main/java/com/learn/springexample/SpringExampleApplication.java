package com.learn.springexample;

import com.learn.springexample.entity.Product;
import com.learn.springexample.repo.ProductRepo;
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
	private ProductRepo repo;



	public static void main(String[] args) {
		System.err.close();
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Product product1 = new Product();
		product1.setCode("1001");
		product1.setName("Coffee");
		product1.setStatus(Product.Status.APPROVED);
		repo.save(product1);

		Product product2 = new Product();
		product2.setCode("1002");
		product2.setName("Milk");
		product2.setStatus(Product.Status.PENDING);
		repo.save(product2);

		Product product3 = new Product();
		product3.setCode("1003");
		product3.setName("Beer");
		product3.setStatus(Product.Status.NOT_APPROVED);
		repo.save(product3);

		Product product4 = new Product();
		product4.setCode("1004");
		product4.setName("Soda");
		repo.save(product4);

		repo.findAll().stream().forEach(p->{
			System.out.println(p.getName()+"\tStatus :\t"+p.getStatus());
		});
	}



}
