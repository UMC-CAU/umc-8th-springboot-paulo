package com.example.umc_spring_mission.apiPayload.exception;

import com.example.umc_spring_mission.apiPayload.code.BaseErrorCode;
import com.example.umc_spring_mission.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    //MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    //Food
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD4001", "음식이 없음."),

    //Neighborhood
    NEIGHBORHOOD_NOT_FOUND(HttpStatus.BAD_REQUEST, "NEIGHBORHOOD4001", "지역이 없음."),

    //User
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4001", "유저가 없음"),

    //Restaurant
    RESTAURANT_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESTAURANT4001", "식당이 없음"),

    //Mission
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "미션이 없음"),
    MISSION_ALREADY_CHALLENGING(HttpStatus.BAD_REQUEST, "MISSION4002", "미션이 이미 진행중임"),

    //UserMission
    USERMISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "USERMISSION4001", "유저미션이 없음"),

    //Page
    PAGE_INDEX_ERROR(HttpStatus.BAD_REQUEST, "PAGE4001",  "페이지 오류");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }
    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
