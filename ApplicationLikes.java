package com.liking.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationLikes {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLikes.class, args);
	}
}
