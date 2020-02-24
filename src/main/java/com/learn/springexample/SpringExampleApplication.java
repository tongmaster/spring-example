package com.learn.springexample;

import com.learn.springexample.entity.Product;
import com.learn.springexample.repo.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Log4j2
@SpringBootApplication
public class SpringExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Autowired
	private ProductRepo repo;


	@Override
	public void run(String... args) {

		Product p1 = new Product();
		p1.setName("AAA");
		p1.setCode("01");
		repo.save(p1);

		Product p2 = new Product();
		p2.setName("BBB");
		p2.setCode("02");
		p2 = repo.save(p2);

		p2.setName("BBB-1");
		repo.save(p2);

		System.out.println(repo.findAll());

	}


}
