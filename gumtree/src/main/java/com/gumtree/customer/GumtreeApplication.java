package com.gumtree.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author MJain
 *
 * Spring boot starter class.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class GumtreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GumtreeApplication.class, args);
	}

}
