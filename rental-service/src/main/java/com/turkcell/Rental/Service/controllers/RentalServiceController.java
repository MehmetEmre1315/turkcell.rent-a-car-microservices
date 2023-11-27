package com.turkcell.Rental.Service.controllers;

import com.turkcell.Rental.Service.dto.requests.AddRentalToDtoRequest;
import com.turkcell.Rental.Service.dto.requests.DeleteRentalCarDto;
import com.turkcell.Rental.Service.dto.requests.IsAvailableToRentRequest;
import com.turkcell.Rental.Service.dto.requests.RentACarDtoRequest;
import com.turkcell.Rental.Service.dto.responses.AddRentalToDtoResponse;
import com.turkcell.Rental.Service.dto.responses.RentACarDtoResponse;
import com.turkcell.Rental.Service.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("RentalService")
@RestController
@RequiredArgsConstructor
public class RentalServiceController {
    private final RentalService rentalService;
    private final KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("addRentalCar")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRentalToDtoResponse addCar(@RequestBody AddRentalToDtoRequest request) {
        return rentalService.addRental(request);
    }

    @PostMapping("isAvailableToRent")
    public boolean  isAvailableToRent(@RequestBody IsAvailableToRentRequest request){
        return rentalService.isAvailableToRent(request);
    }

    @DeleteMapping("deleteByCarId")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody DeleteRentalCarDto request) {rentalService.deleteRentalCar(request);}

    @PostMapping("Rent a Car")
    public RentACarDtoResponse rentCar(@RequestBody RentACarDtoRequest request) {
        kafkaTemplate.send("notificationTopic","Car rented");
        return rentalService.rentCar(request);
    }
    @PostMapping("Return a Car")
    public AddRentalToDtoResponse returnCar (@RequestBody IsAvailableToRentRequest request) {
        return rentalService.returnCar(request);
    }


}
