package com.example.application.controller;

import com.example.application.dto.airplane.AirplaneRequestDto;
import com.example.application.dto.airplane.AirplaneResponseDto;
import com.example.application.dto.airplane.AirplaneUpdateRequestDto;
import com.example.application.service.AirplaneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/airplanes")
@Tag(name = "Airplanes management", description = "Endpoints for airplanes management")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new airplane",
            description = "Endpoint for creating a new airplane")
    public AirplaneResponseDto createTask(
            @RequestBody @Valid AirplaneRequestDto airplaneRequestDto) {
        return airplaneService.save(airplaneRequestDto);
    }

    @PutMapping("/{airplaneId}")
    @Operation(summary = "Move airplanes between companies",
            description = "Endpoint to move airplanes between companies")
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneResponseDto update(@PathVariable Long airplaneId,
                                  @RequestBody @Valid AirplaneUpdateRequestDto airplaneUpdateDto) {
        return airplaneService.updateAirplaneById(airplaneId, airplaneUpdateDto);
    }
}
