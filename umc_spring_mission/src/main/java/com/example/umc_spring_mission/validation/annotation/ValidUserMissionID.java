package com.example.umc_spring_mission.validation.annotation;

import com.example.umc_spring_mission.validation.validator.RestaurantExistValidator;
import com.example.umc_spring_mission.validation.validator.UserMissionIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserMissionIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserMissionID {
    String message() default "해당 유저의 미션이 아닙니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
