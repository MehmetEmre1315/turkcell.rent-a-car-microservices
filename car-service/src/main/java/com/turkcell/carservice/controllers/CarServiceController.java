package com.turkcell.carservice.controllers;

import com.turkcell.carservice.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("CarService")
@RestController
@RequiredArgsConstructor
public class CarServiceController {
    private final CarRepository carRepository;

    public void addCar(String brand, String model, int year, int price) {



    }


}
