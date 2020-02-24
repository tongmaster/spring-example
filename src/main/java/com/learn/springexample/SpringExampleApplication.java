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
	ProductRepo productRepo;
	@Autowired
	OrderRepo orderRepo;

	public static void main(String[] args) {
		System.err.close();
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Product product = new Product();
		product.setCode("1001");
		product.setName("Coffee");
		product.setStatus(Product.Status.APPROVED);
		productRepo.save(product);


		log.debug("Save Order");
		OrderId orderId = new OrderId();
		orderId.setId(1l);
		orderId.setProductId(product.getId());
		Order order = new Order();
		order.setOrderId(orderId);
		order.setQuantity(1);
		order = orderRepo.save(order);


		log.debug("Update Order");
		order.setDetails("too many lines of details");
		orderRepo.save(order);




















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
