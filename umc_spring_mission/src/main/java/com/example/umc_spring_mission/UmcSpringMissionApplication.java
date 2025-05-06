package com.example.umc_spring_mission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@EnableJpaAuditing
public class UmcSpringMissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmcSpringMissionApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabaseConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                System.out.println("✅ MySQL 연결 성공!");
            } catch (Exception e) {
                System.err.println("❌ MySQL 연결 실패: " + e.getMessage());
            }
        };
    }
}
