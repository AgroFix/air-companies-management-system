package com.example.application.service;

import com.example.application.dto.flight.FlightRequestDto;
import com.example.application.dto.flight.FlightResponseDto;
import com.example.application.model.Flight;
import java.util.List;

public interface FlightService {
    FlightResponseDto save(FlightRequestDto requestDto);

    FlightResponseDto updateFlightStatusById(Long flightId, Flight.FlightStatus newStatus);

    List<FlightResponseDto> getAllInActiveStatusMoreThenDay();

    List<FlightResponseDto> getAllByStatusAndAirCompanyName(String status, String airCompanyName);
}
