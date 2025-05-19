package com.example.umc_spring_mission.validation.validator;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.repository.StoreRespository.StoreRepository;
import com.example.umc_spring_mission.validation.annotation.ExistNeighborhood;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NeighborhoodExistValidator implements ConstraintValidator<ExistNeighborhood, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistNeighborhood constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(value);

       if(!isValid) {
           context.disableDefaultConstraintViolation();
           context.buildConstraintViolationWithTemplate(ErrorStatus.NEIGHBORHOOD_NOT_FOUND.toString()).addConstraintViolation();
       }

        return false;
    }
}
