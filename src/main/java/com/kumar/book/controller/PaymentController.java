package com.kumar.book.controller;

import com.kumar.book.annotations.RateLimited;
import com.kumar.book.ratelimiter.RateLimiterService;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final RateLimiterService rateLimiterService;

    public PaymentController(RateLimiterService service) {
        this.rateLimiterService = service;
    }

    @GetMapping("/payment")
    public String payment(HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        Bucket bucket = rateLimiterService.resolveBucket(ip);

        if (!bucket.tryConsume(1)) {
            throw new ResponseStatusException(
                    HttpStatus.TOO_MANY_REQUESTS,
                    "Too many requests"
            );
        }

        return "Payment processed";
    }

    @GetMapping("/payment1")
    @RateLimited(capacity = 10, refillMinutes = 1)
    public String payment() {
        return "Payment processed";
    }

}

