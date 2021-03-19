package com.jfb.stcategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StCategoryApplication.class, args);
	}

}
