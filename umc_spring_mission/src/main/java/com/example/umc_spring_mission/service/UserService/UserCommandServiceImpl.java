package com.example.umc_spring_mission.service.UserService;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc_spring_mission.converter.UserConverter;
import com.example.umc_spring_mission.converter.UserFoodConverter;
import com.example.umc_spring_mission.domain.Food;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserFood;
import com.example.umc_spring_mission.repository.FoodCategoryRepository.FoodCategoryRepository;
import com.example.umc_spring_mission.repository.UserRepository.UserRepository;
import com.example.umc_spring_mission.web.dto.User.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toMember(request);
        List<Food> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserFood> userFoodList = UserFoodConverter.toMemberPreferList(foodCategoryList);

        userFoodList.forEach(userFood -> {userFood.setUser(newUser);});

        return userRepository.save(newUser);
    }
}

