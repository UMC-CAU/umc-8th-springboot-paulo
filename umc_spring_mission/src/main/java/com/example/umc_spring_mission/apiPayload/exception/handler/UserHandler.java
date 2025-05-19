package com.example.umc_spring_mission.apiPayload.exception.handler;

import com.example.umc_spring_mission.apiPayload.code.BaseErrorCode;
import com.example.umc_spring_mission.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {

    public UserHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
