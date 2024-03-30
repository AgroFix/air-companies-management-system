package com.example.application.mapper;

import com.example.application.config.MapperConfig;
import com.example.application.dto.airplane.AirplaneResponseDto;
import com.example.application.model.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    @Mapping(target = "airCompanyId", source = "airCompany.id")
    AirplaneResponseDto toResponseDto(Airplane airplane);
}
