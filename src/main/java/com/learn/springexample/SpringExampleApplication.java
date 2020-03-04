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
		try {
			perform();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

	}



	private void perform() {

		System.out.println("Inserting multiple Products");
		repo.saveAll(Arrays.asList(
				new Product("101", "A1", Product.Status.APPROVED),
				new Product("102", "a2", Product.Status.APPROVED),
				new Product("103", "B1", Product.Status.PENDING,"Hi"),
				new Product("104", "b2", Product.Status.NOT_APPROVED, "Hello")));

		sout("Count number of All Products : " + repo.count());

		sout("Find all");
		repo.findAll().forEach(System.out::println);

		sout("Fetch Product Where Detail Not Null");
		repo.fetchDetailNotNull().get().forEach(System.out::println);

		sout("Fetch Product Where Detail Length > 2");
		repo.fetchDetailLengthGreaterThan2().get().forEach(System.out::println);

		sout("Custom Fetch Product to Pojo");
		repo.customFetchProductToPojo().forEach(System.out::println);

	}



	private void sout(String message) {
		IntStream.range(0, 3).forEach(i -> System.out.println());
		System.out.println(message);
	}

	private void info(String message) {
		log.info(() -> message);
	}



}
