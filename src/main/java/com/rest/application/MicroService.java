package com.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.rest.application"})
public class MicroService {

	public static void main(String[] args) {
		SpringApplication.run(MicroService.class, args);
	}
}
