package com.example.application.repository;

import com.example.application.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
