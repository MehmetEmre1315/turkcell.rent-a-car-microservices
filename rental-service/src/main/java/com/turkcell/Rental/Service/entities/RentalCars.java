package com.turkcell.Rental.Service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rental_cars")
@Builder
public class RentalCars {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column(name="car_id")
    private int carId;
    @Column(name="is_available")
    private boolean isAvailable;
    @Column(name="take_car_date")
    private LocalDate takeCarDate;
    @Column(name="return_car_date")
    private LocalDate returnCarDate;
}
