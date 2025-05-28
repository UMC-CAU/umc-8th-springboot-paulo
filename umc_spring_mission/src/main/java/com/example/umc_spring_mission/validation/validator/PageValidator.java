package com.example.umc_spring_mission.validation.validator;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.validation.annotation.ValidPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_INDEX_ERROR.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
