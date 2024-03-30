package com.example.application.dto.airplane;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class AirplaneRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String factorySerialNumber;

    private Long airCompanyId;
    @NotNull
    private int numberOfFlights;
    @NotNull
    @Positive(message = " cannot be less then 1")
    private BigDecimal flightDistance;
    @NotNull
    @Positive(message = " cannot be less then 1")
    private int fuelCapacity;
    @NotBlank
    private String type;
    @NotNull
    private LocalDate createdAt;
}
