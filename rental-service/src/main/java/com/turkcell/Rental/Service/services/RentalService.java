package com.turkcell.Rental.Service.services;

import com.turkcell.Rental.Service.dto.requests.AddRentalToDtoRequest;
import com.turkcell.Rental.Service.dto.requests.DeleteRentalCarDto;
import com.turkcell.Rental.Service.dto.requests.IsAvailableToRentRequest;
import com.turkcell.Rental.Service.dto.responses.AddRentalToDtoResponse;

public interface RentalService {

    AddRentalToDtoResponse addRental(AddRentalToDtoRequest request);
    boolean isAvailableToRent(IsAvailableToRentRequest request);
    void deleteRentalCar(DeleteRentalCarDto request);

    AddRentalToDtoResponse rentCar(IsAvailableToRentRequest request);
    AddRentalToDtoResponse returnCar(IsAvailableToRentRequest request);

}
