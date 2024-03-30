package com.example.application.dto.flight;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class FlightResponseDto {

    private Long id;

    private String flightStatus;

    private Long airCompanyId;

    private Long airplaneId;

    private String departureCountry;

    private String destinationCountry;

    private BigDecimal distance;

    private LocalTime estimatedFlightTime;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private LocalDateTime delayStartedAt;

    private LocalDateTime createdAt;
}
