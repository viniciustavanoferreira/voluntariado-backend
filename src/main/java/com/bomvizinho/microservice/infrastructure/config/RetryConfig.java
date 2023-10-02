package com.bomvizinho.microservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.support.RetryTemplate;

@EnableRetry
@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        return RetryTemplate.builder()
                .maxAttempts(3)
                .exponentialBackoff(5000, 2, 15000)
                .build();
    }

}
