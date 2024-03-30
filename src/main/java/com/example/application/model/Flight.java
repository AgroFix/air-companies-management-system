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
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@RequiredArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(nullable = false)
    private FlightStatus flightStatus;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AirCompany airCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Airplane airplane;

    @Column(nullable = false)
    private String departureCountry;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
    private BigDecimal distance;
    @Column(nullable = false)
    private LocalTime estimatedFlightTime;
    @Column(nullable = false)
    private LocalDateTime startedAt;
    @Column(nullable = false)
    private LocalDateTime endedAt;
    @Column(nullable = false)
    private LocalDateTime delayStartedAt;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public enum FlightStatus {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
