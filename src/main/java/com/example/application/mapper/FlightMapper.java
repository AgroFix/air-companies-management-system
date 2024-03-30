package com.example.application.mapper;

import com.example.application.config.MapperConfig;
import com.example.application.dto.flight.FlightResponseDto;
import com.example.application.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {
    @Mapping(target = "flightStatus", source = "flightStatus",
            qualifiedByName = "getFlightStatusFromEnum")
    @Mapping(target = "airCompanyId", source = "airCompany.id")
    @Mapping(target = "airplaneId", source = "airplane.id")
    FlightResponseDto toResponseDto(Flight flight);

    @Named("getFlightStatusFromEnum")
    default String getFlightStatusFromEnum(Flight.FlightStatus flightStatus) {
        return flightStatus.toString();
    }
}
