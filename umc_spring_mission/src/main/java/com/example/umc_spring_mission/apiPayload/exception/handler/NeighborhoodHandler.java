package com.example.umc_spring_mission.apiPayload.exception.handler;

import com.example.umc_spring_mission.apiPayload.code.BaseErrorCode;
import com.example.umc_spring_mission.apiPayload.exception.GeneralException;

public class NeighborhoodHandler extends GeneralException {
    public NeighborhoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
