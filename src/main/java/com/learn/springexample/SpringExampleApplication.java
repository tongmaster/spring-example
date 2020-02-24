package com.learn.springexample;

import com.learn.springexample.entity.Order;
import com.learn.springexample.entity.OrderId;
import com.learn.springexample.entity.Product;
import com.learn.springexample.repo.OrderRepo;
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
	private ProductRepo productRepo;

	@Autowired
	private OrderRepo orderRepo;


	public static void main(String[] args) {
		System.err.close();
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Product p1 = new Product();
		p1.setName("AAA");
		p1.setCode("01");
		p1.setStatus(Product.Status.APPROVED);
		p1 = productRepo.save(p1);
		p1.setDetail("abc");
		productRepo.save(p1);

		Order o1 = new Order();
		o1.setOrderId(new OrderId(1l,1l));
		o1.setQuantity(2);
		o1 = orderRepo.save(o1);
		o1.setQuantity(3);
		orderRepo.save(o1);
	}


}
