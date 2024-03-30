package com.example.application.dto.flight;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class FlightRequestDto {
    @NotNull
    @Positive(message = " cannot be less then 1")
    private Long airCompanyId;
    @NotNull
    @Positive(message = " cannot be less then 1")
    private Long airplaneId;
    @NotBlank
    private String departureCountry;
    @NotBlank
    private String destinationCountry;
    @NotNull
    @Positive(message = " cannot be less then 1")
    private BigDecimal distance;
    @NotNull
    private LocalTime estimatedFlightTime;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private LocalDateTime delayStartedAt;
    @NotNull
    private LocalDateTime createdAt;
}
