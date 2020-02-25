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
		IntStream.range(1, 5).forEach(i -> info(" "));

		info("COUNT : " + repo.count());  //0

		// CREATE
		Product product = new Product();
		product.setCode("P001");
		product.setName("COFFEE");
		product.setStatus(Product.Status.APPROVED);
		product.getAliasNames().add("JAVA");
		product.getAliasNames().add("CUPPA");

		repo.save(product);

		info("C [CREATED] : " + product);
		info("COUNT : " + repo.count());  // 1


		// READ
		product = repo.findById(1l).get();

		info("R [READ   ] : " + product);


		// UPDATE
		product.setName("TEA");
		product.setDetail("UPDATED DETAIL");

		product = repo.save(product);

		info("U [UPDATED] : " + product);


		// DELETE
		repo.delete(product);

		info("D [DELETED] : " + repo.findAll());
		info("COUNT : " + repo.count());   // 0

	}

	private void info(String message) {
		log.info(() -> message);
	}




}
