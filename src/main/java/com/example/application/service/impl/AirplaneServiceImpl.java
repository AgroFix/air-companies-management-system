package com.example.application.service.impl;

import com.example.application.dto.airplane.AirplaneRequestDto;
import com.example.application.dto.airplane.AirplaneResponseDto;
import com.example.application.dto.airplane.AirplaneUpdateRequestDto;
import com.example.application.mapper.AirplaneMapper;
import com.example.application.model.AirCompany;
import com.example.application.model.Airplane;
import com.example.application.repository.AirCompanyRepository;
import com.example.application.repository.AirplaneRepository;
import com.example.application.service.AirplaneService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private static final String CANT_FIND_AIR_COMPANY_BY_ID = "Can't find a air company with id: ";
    private static final String CANT_FIND_AIRPLANE_BY_ID = "Can't find a airplane with id: ";
    private final AirCompanyRepository airCompanyRepository;
    private final AirplaneRepository airplaneRepository;
    private final AirplaneMapper airplaneMapper;

    @Override
    @Transactional
    public AirplaneResponseDto save(AirplaneRequestDto requestDto) {
        Airplane airplane = new Airplane();
        Airplane created = savedAirplane(requestDto, airplane);
        return airplaneMapper.toResponseDto(created);
    }

    @Override
    @Transactional
    public AirplaneResponseDto updateAirplaneById(
            Long airplaneId, AirplaneUpdateRequestDto airplaneUpdateRequestDto) {
        Airplane airplane = airplaneRepository.findById(airplaneId).orElseThrow(
                () -> new EntityNotFoundException(CANT_FIND_AIRPLANE_BY_ID + airplaneId));
        AirCompany airCompany = airCompanyRepository
                .findById(airplaneUpdateRequestDto.getAirCompanyId()).orElseThrow(
                        () -> new EntityNotFoundException(CANT_FIND_AIR_COMPANY_BY_ID
                                + airplaneUpdateRequestDto.getAirCompanyId()));
        airplane.setAirCompany(airCompany);
        return airplaneMapper.toResponseDto(airplaneRepository.save(airplane));
    }

    private Airplane savedAirplane(AirplaneRequestDto airplaneRequestDto, Airplane airplane) {
        Optional<AirCompany> airCompanyOptional = Optional.ofNullable(airplaneRequestDto.getAirCompanyId())
                .flatMap(id -> airCompanyRepository.findById(id));

        Airplane createdAirplane = airCompanyOptional.map(airCompany -> newAirplane(airplaneRequestDto, airCompany, airplane))
                .orElseGet(() -> newAirplane(airplaneRequestDto, null, airplane));

        Airplane savedAirplane = airplaneRepository.save(createdAirplane);
        return createdAirplane.setId(savedAirplane.getId());
    }


    private Airplane newAirplane(
            AirplaneRequestDto requestDto, AirCompany airCompany, Airplane airplane) {
        return airplane.setName(requestDto.getName())
                .setFactorySerialNumber(requestDto.getFactorySerialNumber())
                .setAirCompany(airCompany)
                .setNumberOfFlights(requestDto.getNumberOfFlights())
                .setFlightDistance(requestDto.getFlightDistance())
                .setFuelCapacity(requestDto.getFuelCapacity())
                .setType(requestDto.getType())
                .setCreatedAt(requestDto.getCreatedAt());
    }
}
