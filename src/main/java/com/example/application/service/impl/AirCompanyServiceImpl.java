package com.example.application.service.impl;

import com.example.application.dto.aircompany.AirCompanyRequestDto;
import com.example.application.dto.aircompany.AirCompanyResponseDto;
import com.example.application.mapper.AirCompanyMapper;
import com.example.application.model.AirCompany;
import com.example.application.repository.AirCompanyRepository;
import com.example.application.service.AirCompanyService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private static final String ENTITY_NOT_FOUND_ERROR_MESSAGE =
            "Can't find a air company with given id: ";
    private final AirCompanyRepository airCompanyRepository;
    private final AirCompanyMapper airCompanyMapper;

    @Override
    public AirCompanyResponseDto save(AirCompanyRequestDto airCompanyRequestDto) {
        return airCompanyMapper.toResponseDto(airCompanyRepository
                .save(airCompanyMapper.toEntity(airCompanyRequestDto)));
    }

    @Override
    public List<AirCompanyResponseDto> findAll() {
        return airCompanyRepository.findAll().stream()
                .map(airCompanyMapper::toResponseDto)
                .toList();
    }

    @Override
    public AirCompanyResponseDto update(AirCompanyRequestDto airCompanyRequestDto, Long id) {
        AirCompany airCompany = airCompanyRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_NOT_FOUND_ERROR_MESSAGE + id));
        airCompany.setCompanyType(airCompanyRequestDto.getCompanyType());
        airCompany.setName(airCompanyRequestDto.getName());
        airCompany.setFoundedAt(airCompanyRequestDto.getFoundedAt());
        return airCompanyMapper.toResponseDto(airCompanyRepository.save(airCompany));
    }

    @Override
    public void delete(Long id) {
        if (!airCompanyRepository.existsAirCompanyById(id)) {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND_ERROR_MESSAGE + id);
        }
        airCompanyRepository.deleteById(id);
    }

    @Override
    public AirCompanyResponseDto findById(Long id) {
        AirCompany airCompany = airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ENTITY_NOT_FOUND_ERROR_MESSAGE + id)
        );
        return airCompanyMapper.toResponseDto(airCompany);
    }
}
