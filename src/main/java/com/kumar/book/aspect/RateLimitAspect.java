package com.kumar.book.aspect;

import com.kumar.book.annotations.RateLimited;
import io.github.bucket4j.*;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimitAspect {

    private final ConcurrentHashMap<String, Bucket> cache = new ConcurrentHashMap<>();

    @Around("@annotation(rateLimited)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, RateLimited rateLimited) throws Throwable {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes()).getRequest();

        String ip = request.getRemoteAddr();

        Bucket bucket = cache.computeIfAbsent(ip, k -> {
            Bandwidth limit = Bandwidth.simple(
                    rateLimited.capacity(),
                    Duration.ofMinutes(rateLimited.refillMinutes())
            );
            return Bucket.builder().addLimit(limit).build();
        });

        if (!bucket.tryConsume(1)) {
            throw new ResponseStatusException(
                    HttpStatus.TOO_MANY_REQUESTS,
                    "Too many requests"
            );
        }

        return joinPoint.proceed();
    }
}
