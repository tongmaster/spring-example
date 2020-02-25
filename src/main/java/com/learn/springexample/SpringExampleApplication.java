package com.learn.springexample;

import com.learn.springexample.entity.Product;
import com.learn.springexample.repo.OrderRepository;
import com.learn.springexample.repo.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.stream.IntStream;


@Log4j2
@EnableAsync
@SpringBootApplication
public class SpringExampleApplication implements CommandLineRunner {
	@Autowired
	ProductRepository repo;
	@Autowired
	OrderRepository orderRepo;

	public static void main(String[] args) {
		System.err.close();
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		perform();
	}


	private void perform() {
		IntStream.range(0,10).forEach(i->info(" "));
		info("Inserting multiple Products");

		repo.saveAll(Arrays.asList(
				new Product("101", "A1", Product.Status.APPROVED),
				new Product("102", "a2", Product.Status.APPROVED),
				new Product("103", "B1", Product.Status.PENDING),
				new Product("104", "b2", Product.Status.NOT_APPROVED)));


		info("Count number of All Products : " + repo.count());
		repo.findAll().forEach(System.out::println);

		info("Find all 'APPROVED' Products ");
		Product probe1 = new Product();                       // Create Probe
		probe1.setStatus(Product.Status.APPROVED);
		ExampleMatcher matcher1 = ExampleMatcher.matching()   // Create ExampleMatcher
				.withIgnorePaths("id")
				.withIgnorePaths("version");
		Example<Product> example1 = Example.of(probe1, matcher1);       // Create Example
		repo.findAll(example1).forEach(System.out::println);  // Find All By QBE





		info("Find all Products that name contains 'a or A' ");
		Product probe2 = new Product();                            // Create Probe
		probe2.setName("a");
		ExampleMatcher matcher2 = ExampleMatcher.matching()        // Create ExampleMatcher
				.withIgnorePaths("id")
				.withIgnorePaths("version")
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<Product> example2 = Example.of(probe2, matcher2);   // Create Example
		repo.findAll(example2).forEach(System.out::println);       // Find All By QBE





		info("Find all Products that code contains '0' and name startsWith 'b' ");
		Product probe3 = new Product();                            // Create Probe
		probe3.setCode("0");
		probe3.setName("b");
		ExampleMatcher matcher3 = ExampleMatcher.matching()        // Create ExampleMatcher
				.withIgnorePaths("id")
				.withIgnorePaths("version")
				.withMatcher("code", matcher -> matcher.contains())
				.withMatcher("name", matcher -> matcher.startsWith());

		Example<Product> example3 = Example.of(probe3, matcher3);   // Create Example
		repo.findAll(example3).forEach(System.out::println);       // Find All By QBE


	}


	private void info(String message) {
		log.info(() -> message);
	}




}
