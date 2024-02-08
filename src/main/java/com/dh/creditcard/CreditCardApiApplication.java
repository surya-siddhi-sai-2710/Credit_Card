package com.dh.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class CreditCardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApiApplication.class, args);
	}

}
