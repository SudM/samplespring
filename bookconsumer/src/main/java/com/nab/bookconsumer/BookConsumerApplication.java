package com.nab.bookconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//This is the main class of spring boot application.
@SpringBootApplication
public class BookConsumerApplication {
	
	//Initialize the RestTemplate
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookConsumerApplication.class, args);
	}

}
