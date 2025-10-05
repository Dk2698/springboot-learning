package com.kumar.book.service;

import com.kumar.book.annotations.Audit;
import com.kumar.book.annotations.Log;
import org.springframework.stereotype.Component;

//@Component
public class UserService {

    @Log(message = "Calling createUser()")
    @Audit(user = "admin")
    public void createUser(){
        System.out.println("User created");
    }

    @Log
    public void deleteUser(){
        System.out.println("User deleted");
    }

    public void helperMethod(){
        System.out.println("Helper logic (should not be logged or audit");
    }
}
