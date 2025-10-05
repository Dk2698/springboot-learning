package com.kumar.book.service.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Transactional
    public void registerUser(){
        validate(); // Not Transactional
    }

    // extract validate to another spring-managed class or use AopContext
    @Transactional
    public void validate(){
        // not intercepted by proxy when called directly
    }
}
