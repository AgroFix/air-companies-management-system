package com.example.application.service;

import com.example.application.dto.aircompany.AirCompanyRequestDto;
import com.example.application.dto.aircompany.AirCompanyResponseDto;
import java.util.List;

public interface AirCompanyService {
    AirCompanyResponseDto save(AirCompanyRequestDto airCompanyRequestDto);

    List<AirCompanyResponseDto> findAll();

    AirCompanyResponseDto update(AirCompanyRequestDto airCompanyRequestDto, Long id);

    void delete(Long id);

    AirCompanyResponseDto findById(Long id);
}
