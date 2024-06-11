package edu.poly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = { "edu.poly.service.impl" })
@SpringBootApplication
// @ComponentScan({ "edu.poly.service" })
// @EntityScan("edu.poly.domain")
// @EnableJpaRepositories("edu.poly.repository")
public class AmazonShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonShopApplication.class, args);
	}

}
