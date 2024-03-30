package com.example.application.dto.airplane;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class AirplaneUpdateRequestDto {
    @NotNull
    @Positive(message = " cannot be less then 1")
    private Long airCompanyId;
}
