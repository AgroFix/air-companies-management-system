package com.example.application.dto.aircompany;

import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class AirCompanyResponseDto {
    private Long id;

    private String name;

    private String companyType;

    private LocalDate foundedAt;
}
