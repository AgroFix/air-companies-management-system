package com.example.application.repository;

import com.example.application.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    boolean existsAirCompanyById(Long id);
}
