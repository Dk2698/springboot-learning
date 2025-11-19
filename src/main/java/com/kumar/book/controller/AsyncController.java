package com.kumar.book.controller;

import com.kumar.book.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/run")
    public CompletableFuture<String> runAsyncTask() {
        return asyncService.longRunningTask();
    }
}