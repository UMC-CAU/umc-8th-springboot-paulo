package com.example.umc_spring_mission.validation.validator;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository.UserMissionRepository;
import com.example.umc_spring_mission.validation.annotation.ValidUserMissionID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMissionIdValidator implements ConstraintValidator<ValidUserMissionID, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(ValidUserMissionID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long userMissionId, ConstraintValidatorContext context) {
        boolean isValid = userMissionRepository.existsById(userMissionId);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USERMISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
