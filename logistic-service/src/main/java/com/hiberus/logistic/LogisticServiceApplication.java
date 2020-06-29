package com.hiberus.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.hiberus.commons.entities.logistic"})
public class LogisticServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticServiceApplication.class, args);
	}

}
