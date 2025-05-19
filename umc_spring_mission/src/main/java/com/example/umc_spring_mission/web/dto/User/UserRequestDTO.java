package com.example.umc_spring_mission.web.dto.User;

import com.example.umc_spring_mission.domain.enums.Gender;
import com.example.umc_spring_mission.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        String phoneNum;
        @Size(min = 5, max = 12)
        String address;
        Gender gender;
        LocalDate birth;
        boolean phoneNumVerification;
        @ExistCategories
        List<Long> preferCategory;
    }
}