package com.example.application.repository;

import com.example.application.model.Flight;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByFlightStatusAndAirCompany_Name(Flight.FlightStatus status,
                                                         String airCompanyName);

    List<Flight> findAllByFlightStatus(Flight.FlightStatus status);
}
