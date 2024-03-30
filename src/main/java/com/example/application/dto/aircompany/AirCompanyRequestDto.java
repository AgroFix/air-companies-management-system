package com.example.application.dto.aircompany;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class AirCompanyRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String companyType;

    private LocalDate foundedAt;
}
