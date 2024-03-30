package com.example.application.service.impl;

import com.example.application.dto.flight.FlightRequestDto;
import com.example.application.dto.flight.FlightResponseDto;
import com.example.application.mapper.FlightMapper;
import com.example.application.model.AirCompany;
import com.example.application.model.Airplane;
import com.example.application.model.Flight;
import com.example.application.repository.AirCompanyRepository;
import com.example.application.repository.AirplaneRepository;
import com.example.application.repository.FlightRepository;
import com.example.application.service.FlightService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private static final String CANT_FIND_AIR_COMPANY_BY_ID = "Can't find a air company with id: ";
    private static final String CANT_FIND_PLANE_BY_ID = "Can't find a plane with id: ";
    private static final String CANT_FIND_FLIGHT_BY_ID = "Can't find a flight with id: ";
    private static final String INVALID_FLIGHT_STATUS = "Can't find a flight with id: ";

    private final AirCompanyRepository airCompanyRepository;
    private final AirplaneRepository airplaneRepository;
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    @Transactional
    public FlightResponseDto save(FlightRequestDto requestDto) {
        Flight flight = new Flight();
        Flight createdFlight = savedFlight(requestDto, flight);
        return flightMapper.toResponseDto(createdFlight);
    }

    @Override
    @Transactional
    public FlightResponseDto updateFlightStatusById(Long flightId, Flight.FlightStatus newStatus) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(
                () -> new EntityNotFoundException(CANT_FIND_FLIGHT_BY_ID + flightId));
        switch (newStatus) {
            case DELAYED:
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
            case ACTIVE:
                flight.setStartedAt(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setEndedAt(LocalDateTime.now());
                break;
            default:
                throw new IllegalArgumentException(INVALID_FLIGHT_STATUS);
        }
        flight.setFlightStatus(newStatus);
        flightRepository.save(flight);
        return flightMapper.toResponseDto(flight);
    }

    @Override
    public List<FlightResponseDto> getAllInActiveStatusMoreThenDay() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        return flightRepository.findAllByFlightStatus(Flight.FlightStatus.ACTIVE).stream()
                .filter(flight -> flight.getStartedAt().isBefore(twentyFourHoursAgo))
                .map(flightMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<FlightResponseDto> getAllByStatusAndAirCompanyName(
            String status, String airCompanyName) {
        return flightRepository.findAllByFlightStatusAndAirCompany_Name(
                        Flight.FlightStatus.valueOf(status), airCompanyName).stream()
                .map(flightMapper::toResponseDto)
                .toList();
    }

    private Flight savedFlight(FlightRequestDto flightRequestDto, Flight flight) {
        Airplane airplane = airplaneRepository.findById(flightRequestDto.getAirplaneId())
                .orElseThrow(() -> new EntityNotFoundException(CANT_FIND_PLANE_BY_ID
                + flightRequestDto.getAirplaneId()));
        AirCompany airCompany = airCompanyRepository.findById(flightRequestDto.getAirCompanyId())
                .orElseThrow(() -> new EntityNotFoundException(CANT_FIND_AIR_COMPANY_BY_ID
                        + flightRequestDto.getAirCompanyId()));
        Flight createdFlight = newFlight(flightRequestDto, airplane, airCompany, flight);
        Flight savedFlight = flightRepository.save(createdFlight);
        return createdFlight.setId(savedFlight.getId());
    }

    private Flight newFlight(
            FlightRequestDto requestDto, Airplane airplane, AirCompany airCompany, Flight flight) {
        return flight.setFlightStatus(Flight.FlightStatus.PENDING)
                .setAirCompany(airCompany)
                .setAirplane(airplane)
                .setDepartureCountry(requestDto.getDepartureCountry())
                .setDestinationCountry(requestDto.getDestinationCountry())
                .setDistance(requestDto.getDistance())
                .setEstimatedFlightTime(requestDto.getEstimatedFlightTime())
                .setStartedAt(requestDto.getStartedAt())
                .setEndedAt(requestDto.getEndedAt())
                .setDelayStartedAt(requestDto.getDelayStartedAt())
                .setCreatedAt(requestDto.getCreatedAt());
    }

}
