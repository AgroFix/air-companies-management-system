package com.example.application.controller;

import com.example.application.dto.flight.FlightRequestDto;
import com.example.application.dto.flight.FlightResponseDto;
import com.example.application.model.Flight;
import com.example.application.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/flights")
@Tag(name = "Flight management", description = "Endpoints for flight management")
public class FlightController {
    private final FlightService flightService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new flight",
            description = "Endpoint for creating a new flight")
    public FlightResponseDto createFlight(@RequestBody @Valid FlightRequestDto flightRequestDto) {
        return flightService.save(flightRequestDto);
    }

    @PutMapping("/{flightId}")
    @Operation(summary = "Update a flight status",
            description = "Endpoint for updating a flight status")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightResponseDto update(@PathVariable Long flightId,
                                    @RequestParam Flight.FlightStatus newStatus) {
        return flightService.updateFlightStatusById(flightId, newStatus);
    }

    @GetMapping(path = "/active")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all flight",
            description =
                    "Endpoint for getting all active flight and started more than 24 hours ago")
    public List<FlightResponseDto> getAll() {
        return flightService.getAllInActiveStatusMoreThenDay();
    }

    @GetMapping(params = "status", path = "/status")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all flights by status",
            description = "Endpoint for getting all flights by status")
    public List<FlightResponseDto> getAllByStatusAndAirCompanyName(
            @RequestParam String status,@RequestParam String airCompanyName) {
        return flightService.getAllByStatusAndAirCompanyName(status, airCompanyName);
    }
}
