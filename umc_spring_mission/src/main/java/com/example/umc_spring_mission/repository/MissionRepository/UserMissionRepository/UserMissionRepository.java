package com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserMission;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom {


    @Query(
            value = "SELECT um FROM UserMission um " +
                    "JOIN FETCH um.mission m " +
                    "LEFT JOIN FETCH m.restaurant " +
                    "WHERE um.user = :user AND um.isSuccess = :isSuccess",
            countQuery = "SELECT COUNT(um) FROM UserMission um WHERE um.user = :user AND um.isSuccess = :isSuccess"
    )
    Page<UserMission> findAllByUserIsSuccess(@Param("user") User user, @Param("isSuccess") Boolean isSuccess, PageRequest pageRequest);

}