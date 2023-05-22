package com.example.examplespringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableAsync
public class ExampleSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringBootProjectApplication.class, args);
	}
}
