package com.kumar.book.processor;

import com.kumar.book.service.UserServiceAno;

public class AnnotationProcessor {
    public static void main(String[] args) {
        UserServiceAno userServiceAno = new UserServiceAno();

        Class<? extends UserServiceAno> aClass = userServiceAno.getClass();


    }
}
