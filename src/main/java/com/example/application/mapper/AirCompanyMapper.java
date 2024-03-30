package com.example.application.mapper;

import com.example.application.config.MapperConfig;
import com.example.application.dto.aircompany.AirCompanyRequestDto;
import com.example.application.dto.aircompany.AirCompanyResponseDto;
import com.example.application.model.AirCompany;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompanyResponseDto toResponseDto(AirCompany airCompany);

    AirCompany toEntity(AirCompanyRequestDto airCompanyRequestDto);
}
