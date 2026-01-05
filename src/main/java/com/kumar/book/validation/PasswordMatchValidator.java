package com.kumar.book.validation;

import com.kumar.book.service.dto.RegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterDTO> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterDTO dto, ConstraintValidatorContext constraintValidatorContext) {
        return dto.getPassword().equals(dto.getConfirmPassword());
    }
}
