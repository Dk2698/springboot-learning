package com.kumar.book.processor;

import com.kumar.book.service.UserService;

public class AnnotationProcessor {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Class<? extends UserService> aClass = userService.getClass();


    }
}
