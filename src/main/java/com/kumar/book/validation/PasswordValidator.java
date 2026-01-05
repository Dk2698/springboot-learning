package com.kumar.book.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.length() >= 8;
    }
}
