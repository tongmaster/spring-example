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
		// INSERT
		log.info(() -> "BEGIN INSERT");
		Product p = new Product();
		p.setCode("C01");
		p.setName("INSERT");
		p = repo.saveAndFlush(p);
		log.info(() -> "AFTER INSERT : " + repo.findAll());

		// UPDATE BY JPA METHOD
		log.info(() -> "BEGIN UPDATE BY JPA METHOD");
		p.setName("JPA METHOD");
		repo.saveAndFlush(p);
		log.info(() -> "AFTER UPDATE BY JPA METHOD : " + repo.findAll());


		// UPDATE BY JPQL
		log.info(() -> "BEGIN UPDATE BY JPQL");
		try {
			repo.jpqlUpdate("JPQL", "C01");
			log.info(() -> "AFTER UPDATE BY JPQL : " + repo.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// UPDATE BY SQL
		log.info(() -> "BEGIN UPDATE BY SQL");
		try {
			repo.sqlUpdate("SQL", "C01");
			log.info(() -> "AFTER UPDATE BY SQL : " + repo.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
		}


		log.info("END");

	}

}
