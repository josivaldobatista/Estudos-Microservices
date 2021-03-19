package com.jfb.stproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(StProductApplication.class, args);
	}

}
