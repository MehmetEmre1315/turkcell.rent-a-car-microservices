package com.turkcell.carservice.services;

import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService{
    private final CarRepository carRepository;

    @Override
    public AddCarToDtoResponse addCar(AddCarToDtoRequest request) {
        Car car = Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .modelYear(request.getModelYear())
                .dailyRentalPrice(request.getDailyRentalPrice())
                .picture(request.getPicture())
                .build();
        car =  carRepository.save(car);

        AddCarToDtoResponse response = AddCarToDtoResponse.builder()
                .id(car.getId())
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .modelYear(request.getModelYear())
                .dailyRentalPrice(request.getDailyRentalPrice())
                .picture(request.getPicture())
                .build();
        return response;
    }


}
