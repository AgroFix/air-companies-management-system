package com.example.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String factorySerialNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AirCompany airCompany;
    @Column(nullable = false)
    private int numberOfFlights;
    @Column(nullable = false)
    private BigDecimal flightDistance;
    @Column(nullable = false)
    private int fuelCapacity;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private LocalDate createdAt;
}
