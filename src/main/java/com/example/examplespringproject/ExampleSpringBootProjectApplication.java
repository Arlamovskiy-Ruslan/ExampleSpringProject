package com.example.examplespringproject;

import com.example.examplespringproject.exception.UserNotFoundException;
import com.example.examplespringproject.model.User;
import com.example.examplespringproject.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableConfigurationProperties
@EnableCaching
@EnableScheduling
public class ExampleSpringBootProjectApplication {

	@Autowired UserService userService;
	@Autowired PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringBootProjectApplication.class, args);
	}

	@PostConstruct
	public void init() {
		User user = null;
		try {
			userService.getUserByEmail("admin@example.com");
		} catch (UserNotFoundException e) {
			user = User.builder()
					.email("admin@example.com")
					.password(passwordEncoder.encode("admin"))
					.roles("ADMIN")
					.createdBy("system")
					.modifiedBy("system")
					.build();

			userService.save(user);
		}
	}
}
