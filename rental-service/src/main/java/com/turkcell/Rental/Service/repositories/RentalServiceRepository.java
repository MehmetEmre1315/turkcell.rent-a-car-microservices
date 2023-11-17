package com.turkcell.Rental.Service.repositories;

import com.turkcell.Rental.Service.entities.RentalCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalServiceRepository extends JpaRepository<RentalCars, Short> {
//    INSERT INTO rental_cars (car_id, is_available) Values (15, true)
//
//    UPDATE rental_cars SET is_available = false where car_id = 5

    @Query(value = "SELECT is_available FROM rental_cars WHERE car_id = :carId", nativeQuery = true)
    boolean isAvailableByCarId(@Param("carId")int carId);

    RentalCars findByCarId(int carId);
    }
