package com.kumar.book.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
//    @Async("customExecutor")
    public CompletableFuture<String> longRunningTask() {
        try {
            Thread.sleep(5000); // simulate slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Task completed!");
    }
}