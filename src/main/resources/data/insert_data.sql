INSERT INTO air_companies (name, company_type, founded_at) VALUES
('Emirates', 'International', '1985-03-25'),
('Delta Air Lines', 'International', '1924-05-30'),
('Ryanair', 'Low-cost', '1984-07-28'),
('Lufthansa', 'International', '1953-01-06'),
('Southwest Airlines', 'Low-cost', '1967-03-15');

INSERT INTO airplanes (name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at)
VALUES
    ('Boeing 777', 'B777-1234', 1, 100, 50000.00, 100000, 'Passenger', '2020-01-15'),
    ('Airbus A320', 'A320-5678', 3, 150, 40000.50, 75000, 'Passenger', '2019-05-20'),
    ('Boeing 737', 'B737-9876', 5, 200, 60000.75, 80000, 'Passenger', '2018-08-10'),
    ('Airbus A380', 'A380-4321', 2, 50, 80000.25, 150000, 'Passenger', '2021-03-28'),
    ('Boeing 747', 'B747-2468', 4, 75, 70000.00, 120000, 'Cargo', '2022-11-05');

INSERT INTO flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at)
VALUES
    ('ACTIVE', 1, 1, 'USA', 'UK', 5000.00, '06:00:00', '2024-03-30 08:00:00', '2024-03-30 12:00:00', NULL, '2024-03-30 07:00:00'),
    ('COMPLETED', 1, 2, 'UK', 'France', 700.50, '01:30:00', '2024-03-29 15:00:00', '2024-03-29 16:30:00', NULL, '2024-03-29 14:00:00'),
    ('DELAYED', 2, 3, 'France', 'Germany', 800.75, '02:00:00', '2024-03-28 10:00:00', '2024-03-28 13:00:00', '2024-03-28 10:30:00', '2024-03-28 09:00:00'),
    ('PENDING', 3, 4, 'Germany', 'Italy', 1000.25, '02:30:00', NULL, NULL, NULL, '2024-03-27 11:00:00'),
    ('ACTIVE', 2, 5, 'Italy', 'Spain', 1200.00, '03:00:00', '2024-03-26 12:00:00', NULL, NULL, '2024-03-26 10:00:00');

