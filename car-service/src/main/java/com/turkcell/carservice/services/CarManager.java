package com.turkcell.carservice.services;

import com.turkcell.carservice.dto.requests.AddCarToDtoRequest;
import com.turkcell.carservice.dto.requests.AddRentalCar;
import com.turkcell.carservice.dto.requests.GetByIdCarDtoRequest;
import com.turkcell.carservice.dto.responses.AddCarToDtoResponse;
import com.turkcell.carservice.dto.responses.GetByIdCarDtoResponse;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService{
    private final CarRepository carRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    @Transactional
    public AddCarToDtoResponse addCar(AddCarToDtoRequest request) {
        Car car = Car.builder()
                .id(request.getId())
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
        addCarToRentalService(response);
        return response;
    }

    public void addCarToRentalService( AddCarToDtoResponse response){
        AddRentalCar rentalCar = AddRentalCar.builder()
                .carId(response.getId())
                .build();
        webClientBuilder.build()
                .post()
                .uri("http://rental-service/RentalService/addRentalCar")
                .bodyValue(rentalCar)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    public boolean isCarAvailableToRental(int id){
        AddRentalCar rentalCar = AddRentalCar.builder()
                .carId(id)
                .build();

        Boolean isCarAvailable = webClientBuilder.build()
                .post()
                .uri("http://rental-service/RentalService/isAvailableToRent")
                .bodyValue(rentalCar)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        return isCarAvailable;

    }

    @Override
    public GetByIdCarDtoResponse getById(GetByIdCarDtoRequest request) {
        Car car = carRepository.findbyIdQuery(request.getId());

        GetByIdCarDtoResponse response = GetByIdCarDtoResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .modelYear(car.getModelYear())
                .dailyRentalPrice(car.getDailyRentalPrice())
                .picture(car.getPicture())
                .isCarAvailableToRental(isCarAvailableToRental(car.getId()))
                .build();
        return response;
    }

    @Override
    public List<GetByIdCarDtoResponse> getAll() {
        List<Car> cars = carRepository.findAllQuery();
        List<GetByIdCarDtoResponse> responses = new ArrayList<>();
        for (Car car : cars) {
            GetByIdCarDtoResponse response = GetByIdCarDtoResponse.builder()
                    .id(car.getId())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .color(car.getColor())
                    .modelYear(car.getModelYear())
                    .dailyRentalPrice(car.getDailyRentalPrice())
                    .picture(car.getPicture())
                    .isCarAvailableToRental(isCarAvailableToRental(car.getId()))
                    .build();
            responses.add(response);
        }
        return responses;
    }

    @Override
    public void deleteById(GetByIdCarDtoRequest request) {
        carRepository.deleteById(request.getId());

    }

    @Override
    public AddCarToDtoResponse update(AddCarToDtoRequest request) {
        Car car = carRepository.findbyIdQuery(request.getId());
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setColor(request.getColor());
        car.setModelYear(request.getModelYear());
        car.setDailyRentalPrice(request.getDailyRentalPrice());
        car.setPicture(request.getPicture());
        carRepository.save(car);

        AddCarToDtoResponse response = AddCarToDtoResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .modelYear(car.getModelYear())
                .dailyRentalPrice(car.getDailyRentalPrice())
                .picture(car.getPicture())
                .build();
        return response;
    }


}
