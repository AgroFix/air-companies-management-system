package com.example.application.service;

import com.example.application.dto.airplane.AirplaneRequestDto;
import com.example.application.dto.airplane.AirplaneResponseDto;
import com.example.application.dto.airplane.AirplaneUpdateRequestDto;

public interface AirplaneService {
    AirplaneResponseDto save(AirplaneRequestDto requestDto);

    AirplaneResponseDto updateAirplaneById(
            Long airplaneId, AirplaneUpdateRequestDto airplaneUpdateRequestDto);
}
