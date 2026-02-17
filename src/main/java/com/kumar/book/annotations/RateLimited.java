package com.kumar.book.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimited {
    int capacity() default 5;
    int refillMinutes() default 1;
}

