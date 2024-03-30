package com.example.application.dto.airplane;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class AirplaneResponseDto {

    private Long airPlaneId;

    private String name;

    private String factorySerialNumber;

    private Long airCompanyId;

    private int numberOfFlights;

    private BigDecimal flightDistance;

    private int fuelCapacity;

    private String type;

    private LocalDate createdAt;
}
