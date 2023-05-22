package com.example.examplespringproject.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/api/user/v1/**")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedOriginPatterns("*");
            }
        };
    }
}
