package com.kumar.book.ratelimiter;

import io.github.bucket4j.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private final Bandwidth limit;
    private final ConcurrentHashMap<String, Bucket> cache = new ConcurrentHashMap<>();

    public RateLimiterService(Bandwidth limit) {
        this.limit = limit;
    }

    public Bucket resolveBucket(String key) {
        return cache.computeIfAbsent(key, k ->
                Bucket.builder()
                        .addLimit(limit)
                        .build()
        );
    }
}


