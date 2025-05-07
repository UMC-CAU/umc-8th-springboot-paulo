package com.example.umc_spring_mission;

import com.example.umc_spring_mission.domain.QMission;
import com.example.umc_spring_mission.domain.QRestaurant;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserNeighborhood;
import com.example.umc_spring_mission.service.MissionService.PosMissionService.PosMissionQueryService;
import com.example.umc_spring_mission.service.UserInfoService.UserInfoQueryService;
import com.example.umc_spring_mission.service.UserNeighborhoodService.UserNeighborhoodQueryService;
import com.querydsl.core.Tuple;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class UmcSpringMissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmcSpringMissionApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner testDatabaseConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                System.out.println("✅ MySQL 연결 성공!");
            } catch (Exception e) {
                System.err.println("❌ MySQL 연결 실패: " + e.getMessage());
            }
        };
    }*/

    /*
    @Bean
    public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            UserInfoQueryService userInfoQueryService = ctx.getBean(UserInfoQueryService.class);

            long userId = 11;
            System.out.println("Executing findUserInfo with parameter:");
            System.out.println("UserId: " + userId);

            Optional<User> optionalUser = userInfoQueryService.findUserInfo(userId);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                System.out.println(user);  // ← toString() 호출됨
            } else {
                System.out.println("User not found!");
            }
        };
    }
    */

    /*
    @Bean
    public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            UserNeighborhoodQueryService userNeighborhoodQueryService = ctx.getBean(UserNeighborhoodQueryService.class);

            long userId = 21;  // 예: 홍길동
            String dongName = "강남구";  // 예: 강남구

            System.out.println("Executing findUserNeighborhood with parameters:");
            System.out.println("UserId: " + userId);
            System.out.println("DongName: " + dongName);

            Optional<UserNeighborhood> optionalUserNeighborhood = userNeighborhoodQueryService.findUserNeighborhood(userId, dongName);
            if (optionalUserNeighborhood.isPresent()) {
                UserNeighborhood userNeighborhood = optionalUserNeighborhood.get();
                System.out.println(userNeighborhood);  // ← toString() 호출됨
            } else {
                System.out.println("UserNeighborhood not found!");
            }
        };
    }
    */

    @Bean
    public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            PosMissionQueryService posMissionQueryService = ctx.getBean(PosMissionQueryService.class);

            long userId = 21;
            String dongName = "강남구";

            System.out.println("Executing findPosMission with parameters:");
            System.out.println("UserId: " + userId);
            System.out.println("DongName: " + dongName);

            List<Tuple> missions = posMissionQueryService.findPosMission(userId, dongName);

            if (missions.isEmpty()) {
                System.out.println("No missions found!");
            } else {
                for (Tuple tuple : missions) {
                    String restaurantName = tuple.get(QRestaurant.restaurant.name);
                    String restaurantType = tuple.get(QRestaurant.restaurant.restaurantType);
                    Integer remainingDuration = tuple.get(QMission.mission.remainingDuration);
                    String missionDescription = tuple.get(QMission.mission.missionDescription);
                    Integer rewardPoint = tuple.get(QMission.mission.rewardPoint);

                    System.out.println("Restaurant Name: " + restaurantName);
                    System.out.println("Restaurant Type: " + restaurantType);
                    System.out.println("Remaining Duration: " + remainingDuration);
                    System.out.println("Mission Description: " + missionDescription);
                    System.out.println("Reward Point: " + rewardPoint);
                    System.out.println("-------------------------");
                }
            }
        };
    }

}

