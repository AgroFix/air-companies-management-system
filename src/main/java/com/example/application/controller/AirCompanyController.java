package com.example.application.controller;

import com.example.application.dto.aircompany.AirCompanyRequestDto;
import com.example.application.dto.aircompany.AirCompanyResponseDto;
import com.example.application.service.AirCompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/air_companies")
@Tag(name = "Air companies management", description = "Endpoints for Air companies management")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save an air company",
            description = "Endpoint for saving an air company")
    public AirCompanyResponseDto saveAirCompany(
            @RequestBody @Valid AirCompanyRequestDto airCompanyRequestDto) {
        return airCompanyService.save(airCompanyRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all air companies",
            description = "Endpoint for getting all air companies")
    public List<AirCompanyResponseDto> getAll() {
        return airCompanyService.findAll();
    }

    @PutMapping("/{airCompanyId}")
    @Operation(summary = "Update an air companies",
            description = "Endpoint for updating an air companies")
    @ResponseStatus(HttpStatus.CREATED)
    public AirCompanyResponseDto update(@PathVariable Long airCompanyId,
                                  @RequestBody @Valid AirCompanyRequestDto airCompanyDto) {
        return airCompanyService.update(airCompanyDto, airCompanyId);
    }

    @DeleteMapping("/{airCompanyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an air company by id",
            description = "Endpoint for deleting an air company by id")
    public void delete(@PathVariable Long airCompanyId) {
        airCompanyService.delete(airCompanyId);
    }

    @GetMapping("/{airCompanyId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an air company by id",
            description = "Endpoint for getting an air company by id")
    public AirCompanyResponseDto getAirCompanyById(@PathVariable Long airCompanyId) {
        return airCompanyService.findById(airCompanyId);
    }
}
