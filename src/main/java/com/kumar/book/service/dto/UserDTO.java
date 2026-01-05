package com.kumar.book.service.dto;

import com.kumar.book.validation.Update;
import com.kumar.book.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Min(value = 18, message = "Age must be >= 18")
    private int age;

    @ValidPassword
    private String password;

    @NotNull(groups = Update.class) // validation groups
    private Long id;

//    @PostMapping("/create")
//    public void create(@Validated(Create.class) @RequestBody UserDto dto) {}


//    @Validated
//    @RestController
//    @GetMapping("/users/{id}")
//    public String getUser(@PathVariable @Min(1) int id) {
//        return "OK";
//    }

}
