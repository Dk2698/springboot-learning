package com.kumar.book.service.dto;

import com.kumar.book.validation.PasswordMatch;
import lombok.Getter;

@PasswordMatch
@Getter
public class RegisterDTO {
    private String password;
    private String confirmPassword;
}

