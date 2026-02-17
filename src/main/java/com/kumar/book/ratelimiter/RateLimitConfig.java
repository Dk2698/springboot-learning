package com.kumar.book.ratelimiter;

import io.github.bucket4j.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {

    @Bean
    public Bandwidth apiLimit() {
        return Bandwidth.simple(5, Duration.ofMinutes(1));
    }
}
