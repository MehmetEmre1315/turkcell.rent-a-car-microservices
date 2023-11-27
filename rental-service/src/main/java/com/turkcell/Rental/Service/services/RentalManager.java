package com.turkcell.Rental.Service.services;

import com.turkcell.Rental.Service.dto.requests.*;
import com.turkcell.Rental.Service.dto.responses.AddRentalToDtoResponse;
import com.turkcell.Rental.Service.dto.responses.GetByIdCarFromCarServiceResponse;
import com.turkcell.Rental.Service.dto.responses.GetByIdFromCustomerServiceResponse;
import com.turkcell.Rental.Service.dto.responses.RentACarDtoResponse;
import com.turkcell.Rental.Service.entities.RentalCars;
import com.turkcell.Rental.Service.repositories.RentalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService{
    private final RentalServiceRepository rentalServiceRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public AddRentalToDtoResponse addRental(AddRentalToDtoRequest request) {
        RentalCars rentalCars = RentalCars.builder()
                .carId(request.getCarId())
                .isAvailable(true)
                .build();
        rentalCars =rentalServiceRepository.save(rentalCars);

        AddRentalToDtoResponse response = AddRentalToDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .isAvailable(rentalCars.isAvailable())
                .build();
        return response;
    }

    @Override
    public boolean isAvailableToRent(IsAvailableToRentRequest request) {
        return rentalServiceRepository.isAvailableByCarId(request.getCarId());
    }

    @Override
    public void deleteRentalCar(DeleteRentalCarDto request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalServiceRepository.delete(rentalCars);
    }

    @Override
    public RentACarDtoResponse rentCar(RentACarDtoRequest request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalCars.setAvailable(false);
        rentalCars.setTakeCarDate(request.getTakeCarDate());
        rentalCars.setReturnCarDate(request.getReturnCarDate());
        rentalServiceRepository.save(rentalCars);

        RentACarDtoResponse response = RentACarDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .takeCarDate(request.getTakeCarDate())
                .returnCarDate(request.getReturnCarDate())
                .totalPrice
                        (totalRentPrice
                                (request.getTakeCarDate(),
                                        request.getReturnCarDate(),
                                        rentalCars.getCarId()))
                .isCarAvailable(false)
                .isCustomerBalanceSufficient
                        (isCustomerBalanceSufficient
                                ((totalRentPrice(request.getTakeCarDate(),
                                        request.getReturnCarDate(),
                                        rentalCars.getCarId())),
                                        request.getCustomerId()))
                .build();
        return response;
    }

    @Override
    public AddRentalToDtoResponse returnCar(IsAvailableToRentRequest request) {
        RentalCars rentalCars = rentalServiceRepository.findByCarId(request.getCarId());
        rentalCars.setAvailable(true);
        rentalCars.setTakeCarDate(null);
        rentalCars.setReturnCarDate(null);
        rentalServiceRepository.save(rentalCars);
        AddRentalToDtoResponse response = AddRentalToDtoResponse.builder()
                .id(rentalCars.getId())
                .carId(rentalCars.getCarId())
                .isAvailable(rentalCars.isAvailable())
                .build();
        return response;
    }


    public GetByIdCarFromCarServiceResponse GetByIdCarFromCarService(GetByIdCarFromCarServiceRequest request) {
        GetByIdCarFromCarServiceResponse carFromCarService = webClientBuilder.build()
                .post()
                .uri("http://car-service/CarService/getByIdCar")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(GetByIdCarFromCarServiceResponse.class)
                .block();
        return carFromCarService;
    }

    private double totalRentPrice(LocalDate takeCarDate, LocalDate returnCarDate, int carId){
        GetByIdCarFromCarServiceRequest carFromCarServiceRequest = GetByIdCarFromCarServiceRequest.builder()
                .id(carId)
                .build();

        GetByIdCarFromCarServiceResponse carFromCarService = webClientBuilder.build()
                .post()
                .uri("http://car-service/CarService/getByIdCar")
                .bodyValue(carFromCarServiceRequest)
                .retrieve()
                .bodyToMono(GetByIdCarFromCarServiceResponse.class)
                .block();
        float dailyPrice = carFromCarService.getDailyRentalPrice();

        long daysBetween = DAYS.between(takeCarDate, returnCarDate);
        double rentPrice = daysBetween * dailyPrice;

        return rentPrice;
    }

    private boolean  isCustomerBalanceSufficient(double totalPrice, short customerId){
        GetByIdFromCustomerServiceResponse requestBody = GetByIdFromCustomerServiceResponse.builder()
                .customerId(customerId)
                .build();

        GetByIdFromCustomerServiceResponse responseBody = webClientBuilder.build()
                .post()
                .uri("http://customer-service/CustomerService/getById")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(GetByIdFromCustomerServiceResponse.class)
                .block();
        double balance = responseBody.getMoneyOfCustomer();
        if (balance >= totalPrice)
            return true;
        else
            return false;
    }

}
